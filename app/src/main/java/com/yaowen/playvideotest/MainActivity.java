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
        play= (Button) findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        replay= (Button) findViewById(R.id.replay);
        videoView= (VideoView) findViewById(R.id.videoView);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }

    private void initVideoPath() {
        File file=new File(Environment.getExternalStorageDirectory(),"movie.3gp");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onClick(View v) {
        if (v==play){
            if (!videoView.isPlaying()){
                videoView.start();
            }
        }
        if (v==pause){
            if (videoView.isPlaying()){
                videoView.pause();
            }
        }
        if (v==replay){
            if (videoView.isPlaying()){
                videoView.resume();
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
