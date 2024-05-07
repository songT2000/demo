package com.demo.portal.test.state2;

/**
 * 视频的快进状态
 *      可以进行 播放 , 暂停 , 停止 操作
 */
public class SpeedState extends VideoState{


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
        System.out.println("视频快进中");
    }

    @Override
    public void pause() {
        System.out.println("暂停视频");
        this.videoContext.setVideoState(VideoContext.PAUSE_STATE);
    }

}
