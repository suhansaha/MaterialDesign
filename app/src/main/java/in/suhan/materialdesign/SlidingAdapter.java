package in.suhan.materialdesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by suhan on 17/02/15.
 */
public class SlidingAdapter extends FragmentStatePagerAdapter {
    private String[] tabList;

    public SlidingAdapter(FragmentManager fm, String[] tabList) {
        super(fm);
        this.tabList = tabList;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SlidingLayoutFragment();
        Bundle args = new Bundle();
        args.putInt(SlidingLayoutFragment.ARG_PARAM1, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList[position];
    }
}
