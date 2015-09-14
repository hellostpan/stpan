package com.example.stpan.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;

/**
 * 功能：
 * 创建时间:2015/8/21 14:03
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class NetworkActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    private void init(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info!=null&&info.getType()==ConnectivityManager.TYPE_WIFI){
            System.out.println("getType: "+info.getType());
            System.out.println("getTypeName: "+info.getTypeName());
            System.out.println("getExtraInfo: "+info.getExtraInfo());
            System.out.println("getSubtypeName: "+info.getSubtypeName());
            System.out.println("getSubtype: "+info.getSubtype());
        }else if (info!=null&&info.getType()==ConnectivityManager.TYPE_MOBILE){
            System.out.println("getType: "+info.getType());
            System.out.println("getTypeName: "+info.getTypeName());
            System.out.println("getExtraInfo: "+info.getExtraInfo());
            System.out.println("getSubtypeName: "+info.getSubtypeName());
            System.out.println("getSubtype: "+info.getSubtype());
        }else {
            System.out.println("no network!");
        }
    }
}
