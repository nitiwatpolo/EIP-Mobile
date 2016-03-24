package th.co.ask.eip_mobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.fragment.MktReportFragment;
import th.co.ask.eip_mobile.fragment.OptionMenuFragment;
import th.co.ask.eip_mobile.fragment.PlanToWorkFragment;
import th.co.ask.eip_mobile.fragment.SearchFragment;
import th.co.ask.eip_mobile.fragment.TodoFragment;
import th.co.ask.eip_mobile.fragment.WorkPlanFragment;
import th.co.ask.eip_mobile.fragment.WorkPlanReportFragment;
import th.co.ask.eip_mobile.manager.Contextor;

/**
 * Created by nitiwat.li on 16/03/2559.
 */
public class SalCallMenuPagerAdapter extends FragmentStatePagerAdapter {
    private int imgRes[] = {R.drawable.selector_work_plan, R.drawable.selector_plan_to_work, R.drawable.selector_todo,
            R.drawable.selector_search, R.drawable.selector_mkt_report, R.drawable.selector_plan_report};
    private int titleMenu[] = {R.string.menu_sale_call_work_plan, R.string.menu_sale_call_plan_to_work, R.string.menu_sale_call_to_do,
            R.string.menu_sale_call_search, R.string.menu_sale_call_mkt_report, R.string.menu_sale_call_plan_report};
    private final int TAB_WORK_PLAN = 0;
    private final int TAB_PLAN_TO_WORK = 1;
    private final int TAB_TO_DO = 2;
    private final int TAB_SEARCH = 3;
    private final int TAB_MKT_REPORT = 4;
    private final int TAB_PLAN_REPORT = 5;
    private Map<String, Fragment> mPageReferenceMap = new HashMap<String, Fragment>();

    public SalCallMenuPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == TAB_WORK_PLAN) {
            fragment = WorkPlanFragment.newInstance();
            mPageReferenceMap.put("fragment:WorkPlanFragment", fragment);
        } else if (position == TAB_PLAN_TO_WORK) {
            fragment = PlanToWorkFragment.newInstance();
            mPageReferenceMap.put("fragment:PlanToWorkFragment", fragment);
        } else if (position == TAB_TO_DO) {
            fragment = TodoFragment.newInstance();
            mPageReferenceMap.put("fragment:TodoFragment", fragment);
        } else if (position == TAB_SEARCH) {
            fragment = SearchFragment.newInstance();
            mPageReferenceMap.put("fragment:SearchFragment", fragment);
        } else if (position == TAB_MKT_REPORT) {
            fragment = MktReportFragment.newInstance();
            mPageReferenceMap.put("fragment:MktReportFragment", fragment);
        } else if (position == TAB_PLAN_REPORT) {
            fragment = WorkPlanReportFragment.newInstance();
            mPageReferenceMap.put("fragment:WorkPlanReportFragment", fragment);
        }

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        if (position == TAB_WORK_PLAN) {
            mPageReferenceMap.remove("fragment:WorkPlanFragment");
        } else if (position == TAB_PLAN_TO_WORK) {
            mPageReferenceMap.remove("fragment:PlanToWorkFragment");
        } else if (position == TAB_TO_DO) {
            mPageReferenceMap.remove("fragment:TodoFragment");
        } else if (position == TAB_SEARCH) {
            mPageReferenceMap.remove("fragment:SearchFragment");
        } else if (position == TAB_MKT_REPORT) {
            mPageReferenceMap.remove("fragment:MktReportFragment");
        } else if (position == TAB_PLAN_REPORT) {
            mPageReferenceMap.remove("fragment:WorkPlanReportFragment");
        }
    }

    public Fragment getFragment(String key) {
        return mPageReferenceMap.get(key);
    }

    @Override
    public int getCount() {
        return 6;
    }

    public View getTabView(int position) {
        int menuPosition = -1;
        if (position == TAB_WORK_PLAN) {
            menuPosition = TAB_WORK_PLAN;
        } else if (position == TAB_PLAN_TO_WORK) {
            menuPosition = TAB_PLAN_TO_WORK;
        } else if (position == TAB_TO_DO) {
            menuPosition = TAB_TO_DO;
        } else if (position == TAB_SEARCH) {
            menuPosition = TAB_SEARCH;
        } else if (position == TAB_MKT_REPORT) {
            menuPosition = TAB_MKT_REPORT;
        } else if (position == TAB_PLAN_REPORT) {
            menuPosition = TAB_PLAN_REPORT;
        }
        View v = LayoutInflater.from(Contextor.getInstance().getContext()).inflate(R.layout.view_custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.tvTitle);
        tv.setText(titleMenu[menuPosition]);
        ImageView img = (ImageView) v.findViewById(R.id.ivIcon);
        img.setImageResource(imgRes[menuPosition]);
        return v;
    }
}
