package com.example.stpan.activity;

import android.os.Bundle;
import android.telephony.SmsManager;

import java.util.List;

/**
 * 功能：
 * 创建时间:2015/8/21 16:40
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class SendMessageActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    private void init(){
        String string = "hello world hello world hello world hello world hello world";
        String number = "15858155474";
        SmsManager smsManager = SmsManager.getDefault();
        List<String> list = smsManager.divideMessage(string);
        /*for (String s:list){
            smsManager.sendTextMessage(number,null,string,null,null);
        }*/
    }
}
