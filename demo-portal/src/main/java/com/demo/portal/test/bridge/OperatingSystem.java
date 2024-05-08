package com.demo.portal.test.bridge;

/**
 * 实现化角色：定义实现化角色的接口或抽象类，供扩展抽象化角色调用
 */
public abstract class OperatingSystem {

    private VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public VideoFile getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
