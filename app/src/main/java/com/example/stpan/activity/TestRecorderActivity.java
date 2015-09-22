package com.example.stpan.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.czt.mp3recorder.MP3Recorder;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.File;
import java.io.IOException;

public class TestRecorderActivity extends BackActivity implements View.OnClickListener{
    @ViewInject(R.id.iv_start)
    private ImageView imageView;
    @ViewInject(R.id.listView)
    private ListView listView;

    private MP3Recorder mRecorder;
    TestRecorderAdapter adapter;
    private boolean isClicked = true;
    private static final String FILE_PATH = Environment.getExternalStorageDirectory()+"/sowell/";
    private File mp3File = null;
    private String[] listFile;
    @ViewInject(R.id.test_chronometer)
    private Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recorder);
        ViewUtils.inject(this);
        imageView.setOnClickListener(this);

        adapter = new TestRecorderAdapter();
        File pathFile = new File(FILE_PATH);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        listFile=pathFile.list();
        if (listFile!=null){
            listView.setAdapter(adapter);
        }
        setTitle("录音");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + FILE_PATH + listFile[position]), "audio/mp3");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem ok = menu.add("完成");
        ok.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_start:
                try {
                    if (isClicked){
                        isClicked = false;
                        mp3File = new File(FILE_PATH, System.currentTimeMillis()+".mp3");
                        System.out.println("path: "+mp3File.getAbsolutePath());
                        mRecorder = new MP3Recorder(mp3File);
                        imageView.setImageResource(R.mipmap.record_up);
                        chronometer.setFormat("录制时间：(%s)");
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.start();
                        mRecorder.start();
                    }else {
                        isClicked =true;
                        imageView.setImageResource(R.mipmap.record_down);
                        chronometer.stop();
                        mRecorder.stop();
                        File pathFile = new File(FILE_PATH);
                        listFile = pathFile.list();
                        adapter.notifyDataSetChanged();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mRecorder) {
            mRecorder.stop();
        }
    }

    public class TestRecorderAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return listFile.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(TestRecorderActivity.this).inflate(R.layout.list_filerecorder,null);
            TextView filename = (TextView)view.findViewById(R.id.filename);
            filename.setText(listFile[position]);
            return view;
        }
    }

}