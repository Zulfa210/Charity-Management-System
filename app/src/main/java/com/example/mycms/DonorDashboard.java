package com.example.mycms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

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

        //Toolbar toolbar = (Toolbar) findViewById(R.id.search);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.searchmenu,menu);
//
//        MenuItem item = menu.findItem(R.id.search);
//        return super.onCreateOptionsMenu(menu);
//    }

   // @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        switch (id){
//            case R.id.search
//        }
//        return super.onOptionsItemSelected(item);
//    }
}