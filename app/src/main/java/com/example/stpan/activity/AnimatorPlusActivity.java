package com.example.stpan.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 创建时间:2015/8/28 9:08
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class AnimatorPlusActivity extends BackActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private ImageView main_imageView;
    private int [] res = {R.id.iv_act_001,R.id.iv_act_002,R.id.iv_act_003,R.id.iv_act_004,R.id.iv_act_005,R.id.iv_act_006};
    private List<ImageView> list = new ArrayList<>();
    private int mWith;
    private int mHeight;
    private int statusBarHeight;
    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_plus);
        init();
    }

    private void init(){
        getStatusBar();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mWith = displayMetrics.widthPixels;
        mHeight = displayMetrics.heightPixels;
        linearLayout = (LinearLayout) findViewById(R.id.ll_act_animator_main);
        main_imageView = (ImageView) findViewById(R.id.iv_act_animator_main);
        System.out.println(mWith + "  " + mHeight + " " + statusBarHeight);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(mWith/8,mWith/8);
        params.setMargins(mWith - mWith / 8-20, mHeight - mWith /8-20 - statusBarHeight, 0, 0);
        linearLayout.setLayoutParams(params);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(mWith/12,mWith/12);
        main_imageView.setLayoutParams(params2);
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(mWith/12,mWith/12);
        params1.setMargins(mWith - mWith * 5 / 48-20, mHeight - mWith * 5 / 48-20- statusBarHeight, 0, 0);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageView.setLayoutParams(params1);
            list.add(imageView);
        }

    }

    public void click(View view){
        if (!isOpen){
            RotateAnimation rotateAnimation = new RotateAnimation(0,135,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setDuration(300);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setFillEnabled(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(rotateAnimation);
            for (int i = 0; i < list.size(); i++) {
                float x = (float) (Math.cos(i * (Math.PI / 10))*mWith*2/5);
                float y = (float) (Math.sin(i * (Math.PI / 10))*mWith*2/5);
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(list.get(i), "translationX", 0, -x);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(list.get(i), "translationY", 0, -y);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(list.get(i), "scaleX", 0, 1);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(list.get(i), "scaleY", 0, 1);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(list.get(i), "alpha", 0, 1);
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animatorX, animatorY, animator1, animator2, animator3);
                set.setInterpolator(new DecelerateInterpolator());
                set.start();
            }
            isOpen = true;
        }else {
            RotateAnimation rotateAnimation = new RotateAnimation(135,0,Animation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setDuration(300);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setFillEnabled(true);
            rotateAnimation.setInterpolator(new AccelerateInterpolator());
            view.startAnimation(rotateAnimation);
            for (int i = 0; i < list.size(); i++) {
                float x = (float) (Math.cos(i * (Math.PI / 10))*mWith*2/5);
                float y = (float) (Math.sin(i * (Math.PI / 10))*mWith*2/5);
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(list.get(i), "translationX", -x, 0);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(list.get(i), "translationY", -y, 0);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(list.get(i), "scaleX", 1, 0);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(list.get(i), "scaleY", 1, 0);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(list.get(i), "alpha", 1, 0);
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animatorX, animatorY,animator1,animator2,animator3);
                set.setInterpolator(new AccelerateInterpolator());
                set.start();
            }
            isOpen = false;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_act_001:
                System.out.println("001");
                break;
            case R.id.iv_act_002:
                System.out.println("002");
                break;
            case R.id.iv_act_003:
                System.out.println("003");
                break;
            case R.id.iv_act_004:
                System.out.println("004");
                break;
            case R.id.iv_act_005:
                System.out.println("005");
                break;
            case R.id.iv_act_006:
                System.out.println("006");
                break;
            default:
                System.out.println("007");
                break;
        }
    }

    private void getStatusBar(){
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try{
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
