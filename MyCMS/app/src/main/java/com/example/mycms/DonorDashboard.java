package com.example.mycms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class DonorDashboard extends AppCompatActivity {

    private TabLayout tabLayoutd;
    private ViewPager dviewPager;
    private TabItem dtab1,dtab2,dtab3;
    public DPageAdapter dpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_dashboard);

        tabLayoutd=(TabLayout) findViewById(R.id.tablayoutD);
        dtab1= (TabItem) findViewById(R.id.DTab1);
        dtab2= (TabItem) findViewById(R.id.DTab2);
        dtab3= (TabItem) findViewById(R.id.DTab3);

        dviewPager= findViewById(R.id.Dviewpager);

        dpageradapter = new DPageAdapter(getSupportFragmentManager(), tabLayoutd.getTabCount());
        dviewPager.setAdapter(dpageradapter);
        tabLayoutd.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                dviewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() ==0){
                    dpageradapter.notifyDataSetChanged();

                }else if(tab.getPosition()==1){
                    dpageradapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==2){
                    dpageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        dviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutd));
    }
}