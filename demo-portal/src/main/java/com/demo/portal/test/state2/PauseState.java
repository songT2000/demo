package com.demo.portal.test.state2;

/**
 * 视频的暂停状态
 *      可以进行 快进 , 播放 , 停止 操作
 */
public class PauseState extends VideoState{


    @Override
    public void stop() {
        System.out.println("视频停止播放");
        this.videoContext.setVideoState(VideoContext.STOP_STATE);
    }

    @Override
    public void play() {
        System.out.println("播放视频");
        this.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("视频快进");
        this.videoContext.setVideoState(VideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        System.out.println("视频暂停");
    }

}
