package th.co.ask.eip_mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.rey.material.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.adapter.PlanToWorkDetailItemAdapter;
import th.co.ask.eip_mobile.adapter.PlanToWorkTaskItemAdapter;
import th.co.ask.eip_mobile.dao.ListPlanToWorkTodoDetailDao;
import th.co.ask.eip_mobile.dao.PlanToWorkTodoListDao;
import th.co.ask.eip_mobile.dao.PlanToWorkTodoTaskDao;
import th.co.ask.eip_mobile.manager.Contextor;
import th.co.ask.eip_mobile.manager.DividerItemDecoration;
import th.co.ask.eip_mobile.service.PlanToWorkService;
import th.co.ask.eip_mobile.utils.Config;
import th.co.ask.eip_mobile.utils.ServiceEndPoint;


public class PlanToWorkFragment extends Fragment {
    private MaterialDialog dialog;
    private RecyclerView rvTask;
    private RecyclerView rvList;
    private Spinner spinner;
    private TextView tvTodoName;
    private EditText edtSearch;

    private PlanToWorkService planToWorkService;
    private Call<PlanToWorkTodoTaskDao> taskDaoCall;
    private Call<PlanToWorkTodoListDao> listDaoCall;
    private PlanToWorkTodoTaskDao planToWorkTodoTaskDao;
    private PlanToWorkTodoListDao planToWorkTodoListDao;
    private List<ListPlanToWorkTodoDetailDao> listPlanToWorkTodoDetailDaos = new ArrayList<>();
    private List<ListPlanToWorkTodoDetailDao> listPlanToWorkTodoDetailDaosTemp = new ArrayList<>();
    private PlanToWorkTaskItemAdapter taskAdapter;
    private PlanToWorkDetailItemAdapter detailAdapter;
    private int CURRENT_PAGE = 1;

    public interface PlanToWorkListener {
        void onTaskItemClickListener(View itemView, int position);

        void onDetailItemClickListener(View itemView, int position);
    }

    public PlanToWorkFragment() {
        super();
    }

    public static PlanToWorkFragment newInstance() {
        PlanToWorkFragment fragment = new PlanToWorkFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (planToWorkService == null) {
            createPlanToWorkService();
        }
        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_plan_to_work, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        rvTask = (RecyclerView) rootView.findViewById(R.id.rvTask);

        rvList = (RecyclerView) rootView.findViewById(R.id.rvList);

        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        String[] items = getResources().getStringArray(R.array.filter_plan_to_do_title_en);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.row_spn, items);
        adapter.setDropDownViewResource(R.layout.row_spn_dropdown);
        spinner.setAdapter(adapter);

        tvTodoName = (TextView) rootView.findViewById(R.id.tvTodoName);

        edtSearch = (EditText) rootView.findViewById(R.id.edtSearch);

        if (savedInstanceState != null) {
        } else {
            callTask();

        }
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

    private void createPlanToWorkService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceEndPoint.getInstance().getBaseUrlSelect())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        planToWorkService = retrofit.create(PlanToWorkService.class);
    }

    private void callTask() {
        stopTaskRequest();
        taskDaoCall = planToWorkService.planToWork_todoTask("web", "ASKH", "1000000795");
        taskDaoCall.enqueue(callbackTask);
    }

    public void callList(int position) {
        /*
        stopListRequest();
        listDaoCall = planToWorkService.planToWork_todoList("web", "ASKH",
                "1000000795", planToWorkTodoTaskDao.getDetail().get(position).getTodoCode(),
                CURRENT_PAGE, Config.NUM_PER_PAGE_PLAN_TO_WORK, "-", "-");

        listDaoCall.enqueue(callbackList);
        */
    }

    private void stopTaskRequest() {
        if (taskDaoCall != null && taskDaoCall.isExecuted()) {
            taskDaoCall.cancel();
        }
    }

    private void stopListRequest() {
        if (listDaoCall != null && listDaoCall.isExecuted()) {
            listDaoCall.cancel();
        }
    }

    private void setPlanTask() {
        if (taskAdapter == null) {
            taskAdapter = new PlanToWorkTaskItemAdapter(Contextor.getInstance().getContext(), planToWorkTodoTaskDao.getDetail());
            rvTask.setLayoutManager(new LinearLayoutManager(Contextor.getInstance().getContext()));
            rvTask.addItemDecoration(new DividerItemDecoration(Contextor.getInstance().getContext()));
            rvTask.setAdapter(taskAdapter);
            taskAdapter.setOnItemClickListener(new PlanToWorkTaskItemAdapter.OnItemClickListener() {

                @Override
                public void onTaskItemClick(View itemView, int position) {
                    ((PlanToWorkListener) getActivity()).onTaskItemClickListener(itemView, position);
                }
            });
        } else {
            taskAdapter.updateNewData(planToWorkTodoTaskDao.getDetail());
        }
    }


    Callback<PlanToWorkTodoTaskDao> callbackTask = new Callback<PlanToWorkTodoTaskDao>() {
        @Override
        public void onResponse(Call<PlanToWorkTodoTaskDao> call, Response<PlanToWorkTodoTaskDao> response) {
            String str = "";
            try {
                str = response.errorBody().string();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
            if (!str.equals("")) {
                showAlertDialog(str);
            } else {
                taskDaoCall = null;
                if (response.body().getMsg().equals("Complete.")) {
                    planToWorkTodoTaskDao = response.body();
                    setPlanTask();
                } else {
                    showAlertDialog(response.body().getMsg());
                }
            }
        }

        @Override
        public void onFailure(Call<PlanToWorkTodoTaskDao> call, Throwable t) {
            if (t.getMessage() != null && t.getMessage().equals("Canceled") || t.getMessage().equals("Socket closed")) {

            } else {
                showAlertDialog(t.getMessage());
                taskDaoCall = null;
            }
        }
    };

    Callback<PlanToWorkTodoListDao> callbackList = new Callback<PlanToWorkTodoListDao>() {
        @Override
        public void onResponse(Call<PlanToWorkTodoListDao> call, Response<PlanToWorkTodoListDao> response) {
            String str = "";
            try {
                str = response.errorBody().string();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
            if (!str.equals("")) {
                showAlertDialog(str);
            } else {
                listDaoCall = null;
                if (response.body().getMsg().equals("Complete.")) {

                } else {
                    showAlertDialog(response.body().getMsg());
                }
            }
        }

        @Override
        public void onFailure(Call<PlanToWorkTodoListDao> call, Throwable t) {
            if (t.getMessage() != null && t.getMessage().equals("Canceled") || t.getMessage().equals("Socket closed")) {

            } else {
                showAlertDialog(t.getMessage());
                listDaoCall = null;
            }
        }
    };

}
