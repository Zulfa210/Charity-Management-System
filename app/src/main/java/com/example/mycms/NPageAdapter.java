package com.example.mycms;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import static androidx.viewpager.widget.PagerAdapter.POSITION_NONE;

    public class NPageAdapter extends FragmentPagerAdapter {

        private int numberoftabs;
        public NPageAdapter(@NonNull FragmentManager fm, int numberoftabs) {
            super(fm);
            this.numberoftabs = numberoftabs;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Ntab1();
                case 1:
                    return new Ntab2();
                case 2:
                    return new Ntab3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numberoftabs;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }
    }


