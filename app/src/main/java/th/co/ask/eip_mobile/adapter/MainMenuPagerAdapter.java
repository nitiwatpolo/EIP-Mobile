package th.co.ask.eip_mobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import th.co.ask.eip_mobile.fragment.OptionMenuFragment;
import th.co.ask.eip_mobile.fragment.WorkingFragment;

/**
 * Created by nitiwat.li on 16/03/2559.
 */
public class MainMenuPagerAdapter extends FragmentPagerAdapter {

    public MainMenuPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position==0){
            fragment = WorkingFragment.newInstance();
        }else if(position==1){
            fragment = OptionMenuFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "WORKING";
        }else if(position==1){
            return "OPTIONS";
        }
        return super.getPageTitle(position);
    }
}
