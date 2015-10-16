package com.example.stpan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stpan.adapter.MainListViewAdapter;


public class MainActivity extends BaseActivity {
    private ListView listView;
    private String[] strings = {"抽屉","Test","Notification","Network",
            "SendMessage","Animation","LayoutAnimator","AnimatorPlus","ValueAnimator"
    ,"PopupWindow","Record","Fragment","FortAwesome"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        listView = (ListView) findViewById(R.id.lv);
        MainListViewAdapter adapter = new MainListViewAdapter(this,strings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:intent = new Intent(MainActivity.this,ChoutiActivity.class);
                        break;
                    case 1:intent = new Intent(MainActivity.this,Test1.class);
                        break;
                    case 2:intent = new Intent(MainActivity.this,NotificationActivity.class);
                        break;
                    case 3:intent = new Intent(MainActivity.this,NetworkActivity.class);
                        break;
                    case 4:intent = new Intent(MainActivity.this,SendMessageActivity.class);
                        break;
                    case 5:intent = new Intent(MainActivity.this,AnimationActivity.class);
                        break;
                    case 6:intent = new Intent(MainActivity.this,LayoutAnimationActivity.class);
                        break;
                    case 7:intent = new Intent(MainActivity.this,AnimatorPlusActivity.class);
                        break;
                    case 8:intent = new Intent(MainActivity.this,ValueAnimatorActivity.class);
                        break;
                    case 9:intent = new Intent(MainActivity.this,PopupWindowTestActivity.class);
                        break;
                    case 10:intent = new Intent(MainActivity.this,TestRecorderActivity.class);
                        break;
                    case 11:intent = new Intent(MainActivity.this,FragmentActivity.class);
                        break;
                    case 12:intent = new Intent(MainActivity.this,FortAwesomeActivity.class);
                        break;
                }
                if (intent!=null){
                    startActivity(intent);
                }
            }
        });
    }

}
