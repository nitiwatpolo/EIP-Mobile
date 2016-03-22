package th.co.ask.eip_mobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.activity.ApplySaleCallActivity;
import th.co.ask.eip_mobile.adapter.WorkingMenuAdapter;


public class WorkingFragment extends Fragment {
    private RecyclerView listViewMenu;

    private WorkingMenuAdapter adapter;

    public interface WorkingListener{
        void onMenuClickListener();
    }

    public WorkingFragment() {
        super();
    }

    public static WorkingFragment newInstance() {
        WorkingFragment fragment = new WorkingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_working, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        listViewMenu = (RecyclerView) rootView.findViewById(R.id.listViewMenu);
        adapter = new WorkingMenuAdapter();
        listViewMenu.setLayoutManager(new GridLayoutManager(getContext(),3));
        listViewMenu.setAdapter(adapter);
        adapter.setOnItemClickListener(new WorkingMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                ((WorkingListener)getActivity()).onMenuClickListener();
            }
        });
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

}
