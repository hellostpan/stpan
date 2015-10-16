package com.example.stpan.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.zip.Inflater;

/**
 * 功能：
 * 创建时间:2015/9/7 14:23
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class PopupWindowTestActivity extends BackActivity {

    private PopupWindow popupWindow;
    private RelativeLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        init();
    }

    private void init() {
        View inflate = getLayoutInflater().inflate(R.layout.item_popup_window, null);
        linearLayout = (RelativeLayout) findViewById(R.id.ll_popup_window);
        popupWindow = new PopupWindow(inflate,400,150);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
    }

    public void mClick(View view){
        int [] location = new int[2];
        view.getLocationOnScreen(location);
        popupWindow.setFocusable(true);
        switch (view.getId()){
            case R.id.one:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAsDropDown(view);
                break;
            case R.id.two:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY, location[0] + view.getWidth(), location[1]);
                break;
            case R.id.three:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY, location[0]-(popupWindow.getWidth()-view.getWidth())/2, location[1]-popupWindow.getHeight());
                break;
            case R.id.four:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY,location[0]-popupWindow.getWidth(),location[1]);
                break;
        }
    }
}
