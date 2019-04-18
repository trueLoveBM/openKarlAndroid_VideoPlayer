package com.karl.openkarlandroidvideodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.karl.openkarlandroid_videoplayer.VideoPlayerActivity;
import com.karl.openkarlandroid_videoplayer.entity.VideoInfoEnt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String Url1 = "http://172.16.1.220:9000/UploadFile/QuestionBankImgs/889003d7-24c8-4db9-9ea0-220d1d30de3c.mp4";
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest=findViewById(R.id.btnTest);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTest:
                VideoInfoEnt ent=new VideoInfoEnt();
                ent.setVideoStream("标清");
                ent.setVideoUrl(Url1);
                VideoPlayerActivity.showActivity(this,"测试视频",ent);
                break;
        }
    }
}
