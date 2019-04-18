package com.karl.openkarlandroid_videoplayer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.karl.openkarlandroid_videoplayer.entity.VideoInfoEnt;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayerActivity extends AppCompatActivity {
    View rootView;

    PlayerView player;
    ArrayList<VideoInfoEnt> urls;
    private String title;
    private RequestOptions requestOptions;
    List<VideoijkBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);
        urls = (ArrayList) getIntent().getSerializableExtra("data");
        title = this.getIntent().getStringExtra("title");
        list = new ArrayList<VideoijkBean>();
        for (VideoInfoEnt item : urls) {
            VideoijkBean n = new VideoijkBean();
            n.setStream(item.getVideoStream());
            n.setUrl(item.getVideoUrl());
            list.add(n);
        }


        player = new PlayerView(this, rootView)
                .setTitle(title)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(VideoPlayerActivity.this)
                                .load(list.get(0).getUrl())
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(list)
                .startPlay();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 启动方法
     *
     * @param context
     * @param urls
     */
    public static void showActivity(Context context, String title, ArrayList<VideoInfoEnt> urls) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra("data", urls);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    public static void showActivity(Context context, String title, VideoInfoEnt ent) {
        ArrayList<VideoInfoEnt> list = new ArrayList<>();
        list.add(ent);
        showActivity(context, title, list);
    }
}
