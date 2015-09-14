package com.example.stpan.activity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czt.mp3recorder.MP3Recorder;

import java.io.File;

/**
 * 功能：
 * 创建时间:2015/9/2 15:05
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class RecordActivity extends BackActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private MediaRecorder mMediaRecorder;
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
    }

    private void init(){
        mMediaRecorder = new MediaRecorder();
        mMediaPlayer = new MediaPlayer();
        button1 = (Button) findViewById(R.id.btn_act_record_start_record);
        button2 = (Button) findViewById(R.id.btn_act_record_stop_record);
        button3 = (Button) findViewById(R.id.btn_act_record_start_player);
        button4 = (Button) findViewById(R.id.btn_act_record_stop_player);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_act_record_start_record:
                break;
            case R.id.btn_act_record_stop_record:
                break;
            case R.id.btn_act_record_start_player:
                break;
            case R.id.btn_act_record_stop_player:
                break;
        }
    }
}
