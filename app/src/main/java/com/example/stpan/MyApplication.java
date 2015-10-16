package com.example.stpan;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Typeface;

/**
 * 功能：
 * 创建时间:2015/10/15 9:19
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    private SharedPreferences sharedPreferences;
    private Typeface font;
    public static MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        font = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        sharedPreferences = getSharedPreferences("stpan",MODE_APPEND);
    }

    public SharedPreferences getPreferences() {
        return sharedPreferences;
    }

    public Typeface getFont(){
        return font;
    }
}
