package com.example.ngoui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    FloatingActionButton fabAdd, fabEdit, fabEvent;
    TabLayout tabLayout;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    Float translationY = 100f;
    Boolean isMenuOpen = false;
    OvershootInterpolator interpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout1);
        tabItem1 = (TabItem) findViewById(R.id.tab1);
        tabItem2 = (TabItem) findViewById(R.id.tab2);
        tabItem3 = (TabItem) findViewById(R.id.tab3);
        viewPager = (ViewPager) findViewById(R.id.vpager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);
        initFabMenu();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void initFabMenu() {

        fabAdd = findViewById(R.id.add);
        fabEdit = findViewById(R.id.edit);
        fabEvent = findViewById(R.id.event);

        fabEdit.setAlpha(0f);
        fabEvent.setAlpha(0f);

        fabEdit.setTranslationY(translationY);
        fabEvent.setTranslationY(translationY);

        fabAdd.setOnClickListener((View.OnClickListener) this);
        fabEdit.setOnClickListener((View.OnClickListener) this);
        fabEvent.setOnClickListener((View.OnClickListener) this);

    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen;
        fabAdd.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();
        fabEvent.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabEdit.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;
        fabAdd.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();
        fabEvent.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabEdit.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void handleEdit() {
        Log.i(TAG, "handleFabEdit: ");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                Log.i(TAG, "onClick: fab add");
                break;
            case R.id.edit:
                Log.i(TAG, "onClick: fab edit");
                break;
            case R.id.event:
                Log.i(TAG, "onClick: fab event");
                break;
        }

    }
}