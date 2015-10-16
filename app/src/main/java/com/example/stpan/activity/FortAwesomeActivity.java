package com.example.stpan.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.stpan.MyApplication;

/**
 * 功能：
 * 创建时间:2015/10/15 8:39
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class FortAwesomeActivity extends BackActivity{

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fort_awesome);
        init();
    }

    private void init(){
        Typeface font = MyApplication.getInstance().getFont();
        textView1=(TextView) findViewById(R.id.tv_act_fort_awesome1);
        textView2=(TextView) findViewById(R.id.tv_act_fort_awesome2);
        textView3=(TextView) findViewById(R.id.tv_act_fort_awesome3);
        textView1.setTypeface(font);
        textView2.setTypeface(font);
        textView3.setTypeface(font);
    }
}
