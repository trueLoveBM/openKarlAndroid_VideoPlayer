package com.karl.openkarlandroid_videoplayer.entity;

import java.io.Serializable;

public class VideoInfoEnt implements Serializable {

    private String videoStream;

    private String videoUrl;

    public String getVideoStream() {
        return videoStream;
    }

    public void setVideoStream(String videoStream) {
        this.videoStream = videoStream;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
