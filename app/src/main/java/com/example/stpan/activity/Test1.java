package com.example.stpan.activity;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Entity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.util.ArrayMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 功能：
 * 创建时间:2015/6/4 16:49
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class Test1 extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }

    private void init(){
        ArrayMap<String,Object> arrayMap = new ArrayMap<>();
        arrayMap.put("name","stpan");
        arrayMap.put("age","25");
        arrayMap.put("gender","男");
        HashMap hashMap = new HashMap();
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
    }
}
