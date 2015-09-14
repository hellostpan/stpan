package com.example.stpan.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 功能：
 * 创建时间:2015/8/24 16:39
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class AnimationActivity extends BackActivity implements View.OnTouchListener {
    private TextView textView_left;
    private TextView textView_top;
    private TextView textView_right;
    private TextView textView_bottom;
    private ImageView imageView;
    private long time;
    private int with;
    private int height;
    private double movePoint;
    private float fromX = 0;
    private float toX = 0;
    private float fromY = 0;
    private float toY = 0;
    private ValueAnimator valueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        getDisplay();
        init();
    }

    private void getDisplay() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        with = displayMetrics.widthPixels;
        movePoint = with / 5.0 * 4.0 / 5000.0;
        System.out.println(with + "  " + height);
    }

    private void init() {
        textView_left = (TextView) findViewById(R.id.tv_act_animation_left);
        textView_right = (TextView) findViewById(R.id.tv_act_animation_right);
        textView_top = (TextView) findViewById(R.id.tv_act_animation_top);
        textView_bottom = (TextView) findViewById(R.id.tv_act_animation_bottom);
        imageView = (ImageView) findViewById(R.id.iv_act_animation);
        textView_left.setOnTouchListener(this);
        textView_right.setOnTouchListener(this);
        textView_top.setOnTouchListener(this);
        textView_bottom.setOnTouchListener(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(with / 5, with / 5);
        imageView.setLayoutParams(params);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("left:  "+imageView.getLeft()+" = "+imageView.getTop());
                System.out.println("X:  "+imageView.getX()+" = "+imageView.getY());
                System.out.println("translationX:  "+imageView.getRotationX()+" = "+imageView.getRotationY());
            }
        });
    }

    private void startAnimation(int moveTo) {

        height = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getHeight();
        fromX = 0;
        toX = 0;
        fromY = 0;
        toY = 0;
        final float left = imageView.getX();
        final float top = imageView.getY();
        switch (moveTo) {
            case 1:
                fromX = left;
                toX = 0;
                fromY = top;
                toY = top;
                break;
            case 2:
                fromX = left;
                toX = with / 5 * 4;
                fromY = top;
                toY = top;
                break;
            case 3:
                fromX = left;
                toX = left;
                fromY = top;
                toY = 0;
                break;
            case 4:
                fromX = left;
                toX = left;
                fromY = top;
                toY = height - with / 5 - textView_left.getHeight();
                break;

        }
        /*PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("X",fromX,toX);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("Y",fromY,toY);
        ObjectAnimator.ofPropertyValuesHolder(imageView,propertyValuesHolder1,propertyValuesHolder2).setDuration(1000).start();
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);*/

        /*ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,height - with / 5 - textView_left.getHeight());
        valueAnimator.setTarget(imageView);
        valueAnimator.setDuration(1000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView.setTranslationY((Float) animation.getAnimatedValue());
            }
        });*/
        System.out.println(left+" : "+top);
        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((1-left/864)*5000));
        valueAnimator.setObjectValues(new PointF(left, top));
        //valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                PointF pointF = new PointF();
                pointF.x = left+(with / 5 * 4-left) * fraction;
                pointF.y = top+(height - with / 5 - textView_left.getHeight()-top) * fraction * fraction;
                return pointF;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                imageView.setX(pointF.x);
                imageView.setY(pointF.y);
            }
        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.tv_act_animation_left:
                mTouch(event, 1);
                break;
            case R.id.tv_act_animation_right:
                mTouch(event, 2);
                break;
            case R.id.tv_act_animation_top:
                mTouch(event, 3);
                break;
            case R.id.tv_act_animation_bottom:
                mTouch(event, 4);
                break;
        }
        return true;
    }

    private void mTouch(MotionEvent event, int move) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            time = System.currentTimeMillis();
            startAnimation(move);
        } else if (MotionEvent.ACTION_UP == event.getAction()) {
            valueAnimator.cancel();
        }
        //System.out.println(move + ": " + time);
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
