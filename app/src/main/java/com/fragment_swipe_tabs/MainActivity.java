package com.fragment_swipe_tabs;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
    private static final String TAG = ".MainActivity";
    ActionBar actionBar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(TAG, "onTabSelected at " + " position " + position + " from " + positionOffset + " with number of pixels= " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
//                Log.d(TAG, "onTabSelected: " + " position " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == viewPager.SCROLL_STATE_IDLE) {
                    Log.d(TAG, "onPageScrollStateChanged: Idle");
                }
                if (state == viewPager.SCROLL_STATE_DRAGGING) {
                    Log.d(TAG, "onPageScrollStateChanged: Dragging");
                }
                if (state == viewPager.SCROLL_STATE_SETTLING) {
                    Log.d(TAG, "onPageScrollStateChanged: Settling");
                }
            }
        });

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(this);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab1.setText("Tab 2");
        tab1.setTabListener(this);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab1.setText("Tab 3");
        tab1.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(TAG, "onTabSelected: " + " position " + tab.getPosition() + "name" + tab.getText());
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(TAG, "onTabUnselected: " + " position " + tab.getPosition() + "name" + tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(TAG, "onTabReselected: " + " position " + tab.getPosition() + "name" + tab.getText());
    }
}

class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentA();
        }
        if (position == 1) {
            fragment = new FragmentB();
        }
        if (position == 2) {
            fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}