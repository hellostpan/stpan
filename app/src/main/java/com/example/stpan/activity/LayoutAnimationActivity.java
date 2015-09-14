package com.example.stpan.activity;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;

import java.util.Random;

/**
 * 功能：
 * 创建时间:2015/8/26 14:49
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class LayoutAnimationActivity extends BackActivity implements CompoundButton.OnCheckedChangeListener {
    private ViewGroup viewGroup;
    private GridLayout mGridLayout;
    private int mVal;
    private LayoutTransition transition;

    private CheckBox mAppear,mChangeAppear,mDisAppear,mChangeDisAppear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        init();
    }

    private void init(){
        viewGroup = (ViewGroup) findViewById(R.id.act_lay_container);
        mAppear = (CheckBox) findViewById(R.id.id_appear);
        mChangeAppear = (CheckBox) findViewById(R.id.id_change_appear);
        mDisAppear = (CheckBox) findViewById(R.id.id_disappear);
        mChangeDisAppear = (CheckBox) findViewById(R.id.id_change_disappear);

        mAppear.setOnCheckedChangeListener(this);
        mChangeAppear.setOnCheckedChangeListener(this);
        mDisAppear.setOnCheckedChangeListener(this);
        mChangeDisAppear.setOnCheckedChangeListener(this);

        mGridLayout = new GridLayout(this);
        mGridLayout.setColumnCount(4);
        viewGroup.addView(mGridLayout);
        transition = new LayoutTransition();
        mGridLayout.setLayoutTransition(transition);
    }

    public void addBtn(View view){
        final Button button = new Button(LayoutAnimationActivity.this);
        button.setText((++mVal) + "");
        //mGridLayout.addView(button, Math.min(1, mGridLayout.getChildCount()));
        mGridLayout.addView(button, Math.min(1,mGridLayout.getChildCount()==0?0:new Random().nextInt(mGridLayout.getChildCount())+1));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridLayout.removeView(button);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        transition = new LayoutTransition();
        transition.setAnimator(LayoutTransition.APPEARING,(mAppear.isChecked()? ObjectAnimator.ofFloat(this,"scaleX",0,1):null));
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING,(mChangeAppear.isChecked()?ObjectAnimator.ofFloat(this, "scaleX", 0, 1):null));
        transition.setAnimator(LayoutTransition.DISAPPEARING,(mDisAppear.isChecked()?transition.getAnimator(LayoutTransition.DISAPPEARING):null));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,(mChangeDisAppear.isChecked()?transition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING):null));
        mGridLayout.setLayoutTransition(transition);
    }
}
