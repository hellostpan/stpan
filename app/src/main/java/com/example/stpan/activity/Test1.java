package com.example.stpan.activity;

import android.os.Bundle;

import java.io.File;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 功能：
 * 创建时间:2015/6/4 16:49
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class Test1 extends BackActivity {
    private String TAG = "Test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    public static void main(String[] args) {

    }

    private void init(){
        String strings[] = {"张三","李四","王五"};
        File files[] = new File[5];
        Observable.from(files)
                .flatMap(new Func1<File, Observable<File>>() {
                    @Override
                    public Observable<File> call(File file) {
                        return Observable.from(file.listFiles());
                    }
                })
                .filter(new Func1<File, Boolean>() {
                    @Override
                    public Boolean call(File file) {
                        return file.getName().endsWith("");
                    }
                })
                .map(new Func1<File, Object>() {
                    @Override
                    public Object call(File file) {

                        return file;
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {

                    }
                });



    }
}
