package com.example.stpan.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能：
 * 创建时间:2015/8/20 8:43
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "MyBroadcastReceiver";
    public static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_SMS_RECEIVED.endsWith(intent.getAction())){
            Bundle bundle = intent.getExtras();
            if (bundle!=null){
                StringBuilder sb = new StringBuilder();
                Object[] objects = (Object[]) bundle.get("pdus");
                if (objects!=null){
                    SmsMessage[] messages = new SmsMessage[objects.length];
                    for (int i=0;i<objects.length;i++){
                        messages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
                    }
                    for (SmsMessage message:messages){
                        sb.append("短信来自：" ).append(message.getDisplayOriginatingAddress()).append("\n")
                                .append("短信内容：").append(message.getMessageBody()).append("\n");
                    }
                    System.out.println("--------------------->\n" + sb);
                }
            }
            //获取运营商名称
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager!=null){
                System.out.println("form: "+telephonyManager.getSubscriberId());
                System.out.println("form: "+telephonyManager.getNetworkOperatorName());
                System.out.println("form: "+telephonyManager.getSimOperatorName());
            }
        }

    }
}
