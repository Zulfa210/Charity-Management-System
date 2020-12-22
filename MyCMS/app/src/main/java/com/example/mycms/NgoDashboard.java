package com.example.mycms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class NgoDashboard extends AppCompatActivity {

    private TabLayout tabLayoutn;
    private ViewPager nviewPager;
    private TabItem ntab1,ntab2,ntab3;
    public NPageAdapter npageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_dashboard);

        tabLayoutn=(TabLayout) findViewById(R.id.tablayoutN);
        ntab1= (TabItem) findViewById(R.id.NTab1);
        ntab2= (TabItem) findViewById(R.id.NTab2);
        ntab3= (TabItem) findViewById(R.id.NTab3);

        nviewPager= findViewById(R.id.Nviewpager);

        npageradapter = new NPageAdapter(getSupportFragmentManager(), tabLayoutn.getTabCount());
        nviewPager.setAdapter(npageradapter);
        tabLayoutn.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                nviewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() ==0){
                    npageradapter.notifyDataSetChanged();

                }else if(tab.getPosition()==1){
                    npageradapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==3){
                    npageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        nviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutn));
    }
}