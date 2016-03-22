package th.co.ask.eip_mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.adapter.PlanByDateItemAdapter;
import th.co.ask.eip_mobile.dao.AllPlanDao;
import th.co.ask.eip_mobile.dao.ListDayDao;
import th.co.ask.eip_mobile.dao.PlanByDateDao;
import th.co.ask.eip_mobile.manager.DividerItemDecoration;
import th.co.ask.eip_mobile.manager.decorators.EventDecorator;
import th.co.ask.eip_mobile.manager.decorators.HighlightWeekendsDecorator;
import th.co.ask.eip_mobile.manager.decorators.MySelectorDecorator;
import th.co.ask.eip_mobile.manager.decorators.OneDayDecorator;
import th.co.ask.eip_mobile.service.WorkPlanService;
import th.co.ask.eip_mobile.utils.ServiceEndPoint;

public class WorkPlanFragment extends Fragment {
    private MaterialCalendarView calendarView;
    private TextView tvTitleDateSelected;
    private RecyclerView recyclerView;

    private WorkPlanService eipService;
    private Call<AllPlanDao> alllPlanDaoCall;
    private Call<PlanByDateDao> planByDateDaoCall;
    private MaterialDialog dialog;
    private PlanByDateItemAdapter planByDateAdapter;

    public interface WorkPlanListener {
        void onClickListPlanByDateListener();
    }

    public WorkPlanFragment() {
        super();
    }

    public static WorkPlanFragment newInstance() {
        WorkPlanFragment fragment = new WorkPlanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_work_plan, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        calendarView = (MaterialCalendarView) rootView.findViewById(R.id.calendarView);

        calendarView.setTitleFormatter(new MonthArrayTitleFormatter(getResources().getTextArray(R.array.custom_months_en)));
        calendarView.setWeekDayFormatter(new ArrayWeekDayFormatter(getResources().getTextArray(R.array.custom_weekdays_en)));
        calendarView.addDecorators(new MySelectorDecorator(getActivity()));
        calendarView.addDecorators(new HighlightWeekendsDecorator());
        OneDayDecorator oneDayDecorator = new OneDayDecorator();
        calendarView.addDecorators(oneDayDecorator);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
                //If you change a decorate, you need to invalidate decorators
                // oneDayDecorator.setDate(date.getDate());
                //widget.invalidateDecorators();
                callPlanByDate(date.getYear(), date.getMonth(), date.getDay());
            }
        });

        tvTitleDateSelected = (TextView) rootView.findViewById(R.id.tvTitleDateSelected);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        if (eipService == null) {
            createEIPService();
        }

        callAllPlan();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

    private void showAlertDialog(String msg) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(getActivity());
        builder.title(R.string.dialog_txt_button_title_error);
        builder.content(msg);
        builder.typeface("Roboto-Bold.ttf", "Roboto-Regular.ttf");
        builder.cancelable(true);
        builder.positiveText(R.string.dialog_txt_button_ok);
        dialog = builder.show();
    }

    private void createEIPService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceEndPoint.getInstance().getBaseUrlSelect())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        eipService = retrofit.create(WorkPlanService.class);
    }

    private void callAllPlan() {
        stopRequest();
        alllPlanDaoCall = eipService.workPlan_allPlan("web", "ASKH", "1000000795");
        alllPlanDaoCall.enqueue(callbackAllPlan);
    }

    private void setPlanEvents(AllPlanDao allPlanDao) {
        Calendar calendar = Calendar.getInstance();

        ArrayList<CalendarDay> datesNegative = new ArrayList<>();
        ArrayList<CalendarDay> datesPositive = new ArrayList<>();

        for (int i = 0; i < allPlanDao.getListDay().size(); i++) {
            ListDayDao listDayDao = allPlanDao.getListDay().get(i);
            calendar.set(Integer.valueOf(listDayDao.getYear()),
                    Integer.valueOf(listDayDao.getMonth()) - 1,
                    Integer.valueOf(listDayDao.getDay()));
            CalendarDay day = CalendarDay.from(calendar);
            if (listDayDao.getActive().equals("NEGATIVE")) {
                datesNegative.add(day);
            } else if (listDayDao.getActive().equals("POSITIVE")) {
                datesPositive.add(day);
            }
        }

        calendarView.addDecorators(new EventDecorator(ContextCompat.getColor(getActivity(), R.color.colorEventNegative), datesNegative),
                new EventDecorator(ContextCompat.getColor(getActivity(), R.color.colorEventPositive), datesPositive));

    }

    private void callPlanByDate(int year, int month, int day) {
        stopRequest();
        String date = year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", day);
        planByDateDaoCall = eipService.workPlan_PlanByDate("web", "ASKH", "1000000795", date);
        planByDateDaoCall.enqueue(callbackPlanByDate);
    }

    private void setListPlanByDate(PlanByDateDao planByDateDao) {
        tvTitleDateSelected.setText(planByDateDao.getPlanDate());

        if (planByDateAdapter == null) {
            planByDateAdapter = new PlanByDateItemAdapter(getActivity(), planByDateDao.getListPlan());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
            recyclerView.setAdapter(planByDateAdapter);
            planByDateAdapter.setOnItemClickListener(new PlanByDateItemAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View itemView, int position) {
                    Toast.makeText(getActivity(), "Position:" + position, Toast.LENGTH_LONG).show();
                    //((WorkPlanListener)getActivity()).onClickListPlanByDateListener();
                }
            });
        } else {
            planByDateAdapter.updateNewData(planByDateDao.getListPlan());
        }

    }

    private void stopRequest() {
        if (alllPlanDaoCall != null && alllPlanDaoCall.isExecuted()) {
            alllPlanDaoCall.cancel();
        }
        if (planByDateDaoCall != null && planByDateDaoCall.isExecuted()) {
            planByDateDaoCall.cancel();
        }
    }


    Callback<AllPlanDao> callbackAllPlan = new Callback<AllPlanDao>() {
        @Override
        public void onResponse(Call<AllPlanDao> call, Response<AllPlanDao> response) {
            String str = "";
            try {
                str = response.errorBody().string();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
            if (!str.equals("")) {
                showAlertDialog(str);
            } else {
                alllPlanDaoCall = null;
                if (response.body().getMsg().equals("Complete.")) {
                    setPlanEvents(response.body());
                } else {
                    showAlertDialog(response.body().getMsg());
                }
            }
        }

        @Override
        public void onFailure(Call<AllPlanDao> call, Throwable t) {
            if (!alllPlanDaoCall.isCanceled()) {
                showAlertDialog(t.getMessage());
                alllPlanDaoCall = null;
            }

        }
    };

    Callback<PlanByDateDao> callbackPlanByDate = new Callback<PlanByDateDao>() {
        @Override
        public void onResponse(Call<PlanByDateDao> call, Response<PlanByDateDao> response) {
            String str = "";
            try {
                str = response.errorBody().string();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
            if (!str.equals("")) {
                showAlertDialog(str);
            } else {
                planByDateDaoCall = null;
                setListPlanByDate(response.body());
            }
        }

        @Override
        public void onFailure(Call<PlanByDateDao> call, Throwable t) {
            if (!planByDateDaoCall.isCanceled()) {
                showAlertDialog(t.getMessage());
                planByDateDaoCall = null;
            }

        }
    };

}
