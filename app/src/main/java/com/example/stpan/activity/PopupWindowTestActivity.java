package com.example.stpan.activity;

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
        popupWindow = new PopupWindow(inflate,400,250);
        popupWindow.setOutsideTouchable(true);
    }

    public void mClick(View view){
        float x = view.getX();
        float y = view.getY();
        switch (view.getId()){
            case R.id.one:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAsDropDown(view);
                break;
            case R.id.two:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAsDropDown(view);
                break;
            case R.id.three:
                if (popupWindow.isShowing())popupWindow.dismiss();
                popupWindow.showAtLocation(linearLayout, Gravity.CENTER,0,0);
                break;
        }
    }
}
