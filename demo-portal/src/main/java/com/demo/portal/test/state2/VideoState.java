package com.demo.portal.test.state2;

/**
 * 视频状态 父类
 *      所有的视频状态 , 都要继承该类
 */
public abstract class VideoState {
    // 环境对象
    /**
     * 视频播放上下文
     *      声明为 protected , 子类可以拿到该成员变量
     */
    protected VideoContext videoContext;

    public void setVideoContext(VideoContext videoContext){
        this.videoContext = videoContext;
    }

    //抽象状态执行方法
    public abstract void stop();

    public abstract void play();

    public abstract void speed();

    public abstract void pause();



}
