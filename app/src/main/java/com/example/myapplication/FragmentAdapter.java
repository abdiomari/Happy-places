package com.example.myapplication;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new NairobiiFragment();
            case 1:
                return new NakuruFragment();
            case 2:
                return new MombasaFragment();
            case 3:
                return new KisumuFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 4; }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "County 47";
            case 1:
                return "county 001";
            case 2:
                return "county 32";
            case 3:
                return "county 21";
            default:
                return null;
        }
    }
}
