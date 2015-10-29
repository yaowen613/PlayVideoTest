package com.yaowen.playvideotest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play,pause,replay;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化所有控件
        play= (Button) findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        replay= (Button) findViewById(R.id.replay);
        videoView= (VideoView) findViewById(R.id.videoView);

        //设置按钮的点击事件
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();//初始视频路径
    }

    private void initVideoPath() {
        File file=new File(Environment.getExternalStorageDirectory(),"movie.3gp");
        videoView.setVideoPath(file.getPath());//初始视频路径
    }

    @Override
    public void onClick(View v) {
        if (v==play){
            if (!videoView.isPlaying()){
                videoView.start();//开始播放
            }
        }
        if (v==pause){
            if (videoView.isPlaying()){
                videoView.pause();//暂停播放
            }
        }
        if (v==replay){
            if (videoView.isPlaying()){
                videoView.resume();//重新播放
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView!=null){
            videoView.suspend();
        }
    }
}
