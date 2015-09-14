package com.example.stpan.activity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.stpan.activity.R;

/**
 * Created by Administrator on 2015/4/9.
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    protected Toolbar toolbar;
    protected TextView toolbarTitle;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initToolbar();
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
    }

    protected void initToolbar() {
        View v = findViewById(R.id.toolbar);
        if (v!=null){
            toolbar = (Toolbar) v;//
            setSupportActionBar(toolbar);
            toolbarTitle = (TextView) v.findViewById(R.id.toolbar_title);
            if (toolbarTitle!=null){
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (toolbarTitle!=null){
            toolbarTitle.setText(title);
        }
    }
}
