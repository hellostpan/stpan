package com.example.stpan.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RemoteViews;

/**
 * 功能：
 * 创建时间:2015/8/20 14:43
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class NotificationActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    private void init(){
        Notification notification;
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(NotificationActivity.this);
        builder.setSmallIcon(R.mipmap.ic_arrow_back_grey600_18dp);

        /*FLAG_AUTO_CANCEL  该通知能被状态栏的清除按钮给清除掉
        FLAG_NO_CLEAR    该通知能被状态栏的清除按钮给清除掉
        FLAG_ONGOING_EVENT 通知放置在正在运行
        FLAG_INSISTENT 是否一直进行，比如音乐一直播放，知道用户响应*/
        builder.setDefaults(Notification.FLAG_AUTO_CANCEL);
        builder.setProgress(100, 10, false);
        //builder.setTicker("hello shanghai");
        builder.setContentTitle("张三");
        builder.setContentText("此地无银三百两");
        notification = builder.build();
        notification.defaults = Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE;
        notification.when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(NotificationActivity.this,ChoutiActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),101,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        notification.contentIntent = pendingIntent;
        manager.notify(101,notification);
    }
}
