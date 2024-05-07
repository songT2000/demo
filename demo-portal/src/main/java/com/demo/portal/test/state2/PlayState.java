package com.demo.portal.test.state2;


/**
 * 视频的播放状态
 *      可以进行 快进 , 暂停 , 停止 操作
 */
public class PlayState extends VideoState{

    @Override
    public void stop() {
        System.out.println("停止视频");
        this.videoContext.setVideoState(VideoContext.STOP_STATE);
    }

    @Override
    public void play() {
        System.out.println("播放视频");
    }

    @Override
    public void speed() {
        System.out.println("快进视频");
        this.videoContext.setVideoState(VideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        System.out.println("暂停视频");
        this.videoContext.setVideoState(VideoContext.PAUSE_STATE);
    }

}
