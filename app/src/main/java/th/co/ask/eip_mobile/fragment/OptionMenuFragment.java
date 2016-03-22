package th.co.ask.eip_mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.adapter.OptionMenuAdapter;
import th.co.ask.eip_mobile.manager.DividerItemDecoration;

public class OptionMenuFragment extends Fragment {
    private RecyclerView listViewMenu;
    private OptionMenuAdapter optionMenuAdapter;

    private String[] arrMenu;

    public OptionMenuFragment() {
        super();
    }

    public static OptionMenuFragment newInstance() {
        OptionMenuFragment fragment = new OptionMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        arrMenu = getResources().getStringArray(R.array.optionsMenu);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_option_menu, container, false);
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
        optionMenuAdapter = new OptionMenuAdapter(arrMenu);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(optionMenuAdapter);
        alphaAdapter.setDuration(2000);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        alphaAdapter.setFirstOnly(false);
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        listViewMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        listViewMenu.addItemDecoration(new DividerItemDecoration(getContext()));
        listViewMenu.setAdapter(scaleAdapter);
        optionMenuAdapter.setOnItemClickListener(new OptionMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(getContext(), position + " was clicked!", Toast.LENGTH_SHORT).show();
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
