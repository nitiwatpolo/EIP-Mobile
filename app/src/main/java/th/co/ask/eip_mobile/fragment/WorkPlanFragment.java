package th.co.ask.eip_mobile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.view.ContextThemeWrapper;
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
import th.co.ask.eip_mobile.manager.Contextor;
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

    private WorkPlanService workPlanService;
    private Call<AllPlanDao> alllPlanDaoCall;
    private Call<PlanByDateDao> planByDateDaoCall;
    private MaterialDialog dialog;
    private PlanByDateItemAdapter planByDateAdapter;
    private int day_selected;
    private int month_selected;
    private int year_selected;
    private String date_selected;
    private ArrayList<CalendarDay> datesNegative = new ArrayList<>();
    private ArrayList<CalendarDay> datesPositive = new ArrayList<>();
    private AllPlanDao allPlanDao;
    private PlanByDateDao planByDateDao;

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

        if (workPlanService == null) {
            createWorkPlanService();
        }

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View rootView = localInflater.inflate(R.layout.fragment_work_plan, container, false);

        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
        Calendar calendar = Calendar.getInstance();
        day_selected = calendar.get(Calendar.DAY_OF_MONTH);
        month_selected = calendar.get(Calendar.MONTH);
        year_selected = calendar.get(Calendar.YEAR);
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
                year_selected = date.getYear();
                month_selected = date.getMonth();
                day_selected = date.getDay();
                callPlanByDate(year_selected, month_selected, day_selected);
            }
        });
        calendarView.setSelectedDate(CalendarDay.from(year_selected, month_selected, day_selected));
        calendarView.setCurrentDate(CalendarDay.from(year_selected, month_selected, day_selected));
        tvTitleDateSelected = (TextView) rootView.findViewById(R.id.tvTitleDateSelected);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        callAllPlan();
        callPlanByDate(year_selected, month_selected, day_selected);
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
        builder.cancelable(false);
        builder.positiveText(R.string.dialog_txt_button_ok);
        dialog = builder.show();
    }

    private void createWorkPlanService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceEndPoint.getInstance().getBaseUrlSelect())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        workPlanService = retrofit.create(WorkPlanService.class);
    }

    private void callAllPlan() {
        stopAllPlanCall();
        alllPlanDaoCall = workPlanService.workPlan_allPlan("web", "ASKH", "1000000795");
        alllPlanDaoCall.enqueue(callbackAllPlan);
    }

    private void setPlanEvents() {
        Calendar calendar = Calendar.getInstance();
        datesNegative.clear();
        datesPositive.clear();
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

        calendarView.addDecorators(new EventDecorator(ContextCompat.getColor(Contextor.getInstance().getContext(), R.color.colorEventNegative), datesNegative),
                new EventDecorator(ContextCompat.getColor(Contextor.getInstance().getContext(), R.color.colorEventPositive), datesPositive));

    }

    private void callPlanByDate(int year, int month, int day) {
        stopPlanByDateCall();
        String date = year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", day);
        planByDateDaoCall = workPlanService.workPlan_PlanByDate("web", "ASKH", "1000000795", date);
        planByDateDaoCall.enqueue(callbackPlanByDate);
    }

    private void setListPlanByDate() {
        tvTitleDateSelected.setText(planByDateDao.getPlanDate());

        if (planByDateAdapter == null) {
            planByDateAdapter = new PlanByDateItemAdapter(Contextor.getInstance().getContext(), planByDateDao.getListPlan());
            recyclerView.setLayoutManager(new LinearLayoutManager(Contextor.getInstance().getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(Contextor.getInstance().getContext()));
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

    private void stopAllPlanCall() {
        if (alllPlanDaoCall != null && alllPlanDaoCall.isExecuted()) {
            alllPlanDaoCall.cancel();
        }
    }

    private void stopPlanByDateCall() {
        if (planByDateDaoCall != null && planByDateDaoCall.isExecuted()) {
            planByDateDaoCall.cancel();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopAllPlanCall();
        stopPlanByDateCall();
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
                    allPlanDao = response.body();
                    setPlanEvents();
                } else {
                    showAlertDialog(response.body().getMsg());
                }
            }
        }

        @Override
        public void onFailure(Call<AllPlanDao> call, Throwable t) {
            if (t != null && (t.getMessage().equals("Canceled") || t.getMessage().equals("Socket closed"))) {

            } else {
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
                planByDateDao = response.body();
                setListPlanByDate();
            }
        }

        @Override
        public void onFailure(Call<PlanByDateDao> call, Throwable t) {
            if (t != null && (t.getMessage().equals("Canceled") || t.getMessage().equals("Socket closed"))) {

            } else {
                showAlertDialog(t.getMessage());
                planByDateDaoCall = null;
            }


        }
    };

}
