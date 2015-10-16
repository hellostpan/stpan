package com.example.stpan.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

/**
 * 功能：
 * 创建时间:2015/8/31 9:18
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class ValueAnimatorActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
    }

    private void init(){

    }

    public void btnClick(View view){
        final Button button = (Button) view;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(90,100);
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int a = (int) animation.getAnimatedValue();
                button.setText(a + "");
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(ValueAnimatorActivity.this,"100",Toast.LENGTH_SHORT).show();
            }
        });
        valueAnimator.start();

    }
    public void btnClickT(View view){
        final Button button = (Button) view;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(1);
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                return 100*fraction;
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.setText(animation.getAnimatedValue() + "");
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(ValueAnimatorActivity.this, "100", Toast.LENGTH_SHORT).show();
                
            }
        });
        valueAnimator.start();

    }
}
