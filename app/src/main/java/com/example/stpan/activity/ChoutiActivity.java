package com.example.stpan.activity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import com.example.stpan.fragment.HomeFragment;
import com.nineoldandroids.view.ViewHelper;
import com.example.stpan.activity.R;
/**
 * Created by Administrator on 2015/4/28.
 */
public class ChoutiActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private boolean isDrawerOpened = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chouti);
        init();
    }

    private void init(){
        getSupportFragmentManager().beginTransaction().replace(R.id.menu,new HomeFragment()).commit();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isDrawerOpened = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isDrawerOpened = false;
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float scale = 1 - slideOffset;
                View mContent = mDrawerLayout.getChildAt(0);
                mContent.animate().translationX(drawerView.getMeasuredWidth() * (1 - scale)).setDuration(0);
                //ViewHelper.setTranslationX(mContent, drawerView.getMeasuredWidth() * (1 - scale));
                //ViewHelper.setPivotX(mContent, 0);
                //ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                mContent.invalidate();
            }
        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
}
