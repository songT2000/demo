package com.demo.portal.test.state2;

/**
 * 视频的停止状态
 *      可以进行 播放操作
 *      不可以进行 快进 暂停
 */
public class StopState extends VideoState{


    @Override
    public void stop() {
        System.out.println("视频停止播放");
    }

    @Override
    public void play() {
        System.out.println("播放视频");
        this.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("视频停止，无法快进");
    }

    @Override
    public void pause() {
        System.out.println("视频停止， 无法暂停");
    }

}
