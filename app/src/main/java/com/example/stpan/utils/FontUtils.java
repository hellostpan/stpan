package com.example.stpan.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 功能：
 * 创建时间:2015/10/14 15:55
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class FontUtils {
    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    public static void markAsIconContainer(View v, Typeface typeface) {
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                //markAsIconContainer(child);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(typeface);
        }
    }
}
