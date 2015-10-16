package com.example.stpan.activity;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * 功能：
 * 创建时间:2015/9/22 15:41
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class FragmentActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        init();
    }

    private void init(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int with = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        System.out.println(with+"  :  "+height);
    }
}
