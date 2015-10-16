package com.example.stpan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint.Style;
/**
 * 功能：
 * 创建时间:2015/9/30 15:48
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class CustomViewOfMyself extends View {


    public CustomViewOfMyself(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewOfMyself(Context context) {
        super(context);
    }

    public CustomViewOfMyself(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint_blue = new Paint();//绘制蓝色的环
        paint_blue.setColor(Color.BLUE);
        paint_blue.setAntiAlias(true);//设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢。
        paint_blue.setStyle(Style.STROKE);
        paint_blue.setDither(true);
        paint_blue.setStrokeWidth(20);
        canvas.drawCircle(110, 150, 60, paint_blue);

        Paint paint_yellow = new Paint();                //绘制黄色的环
        paint_yellow.setColor(Color.YELLOW);
        paint_yellow.setStyle(Style.STROKE);
        paint_yellow.setAntiAlias(true);
        paint_yellow.setStrokeWidth(10);
        canvas.drawCircle((float)175.5, 210, 60, paint_yellow);

        Paint paint_black = new Paint();                   //绘制黑色的环
        paint_black.setColor(Color.BLACK);
        paint_black.setStyle(Style.STROKE);
        paint_black.setStrokeWidth(10);
        paint_black.setAntiAlias(true);
        canvas.drawCircle(245, 150, 60, paint_black);

        Paint paint_green = new Paint();                  //绘制绿色的环
        paint_green.setColor(Color.GREEN);
        paint_green.setStyle(Style.STROKE);
        paint_green.setStrokeWidth(10);
        paint_green.setAntiAlias(true);
        canvas.drawCircle(311, 210, 60, paint_green);

        Paint paint_red = new Paint();                       //绘制红色的环
        paint_red.setColor(Color.RED);
        paint_red.setStyle(Style.STROKE);
        paint_red.setAntiAlias(true);
        paint_red.setStrokeWidth(10);
        canvas.drawCircle(380, 150, 60, paint_red);

        Paint paint_string = new Paint();                   //绘制字符串
        paint_string.setColor(Color.BLUE);
        paint_string.setTextSize(20);
        canvas.drawText("Welcome to Beijing", 245, 310, paint_string);

        Paint paint_line = new Paint();                       //绘制直线
        paint_line.setColor(Color.BLUE);
        canvas.drawLine(240, 310, 425, 310, paint_line);

        Paint paint_text = new Paint();                      //绘制字符串
        paint_text.setColor(Color.BLUE);
        paint_text.setTextSize(20);
        canvas.drawText("北京欢迎您", 275, 330, paint_text);
    }
}
