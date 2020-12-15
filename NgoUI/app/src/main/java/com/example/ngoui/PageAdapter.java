package com.example.ngoui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ngoui.appo;
import com.example.ngoui.profile;
import com.example.ngoui.search;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new appo();
            case 1: return new search();
            case 2: return new profile();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
