package com.demo.portal.test.state2;


/**
 * 使用享元模式 , 共享同一个对象
 * <p>
 * 上下文也有 play , pause , speed , stop 等状态
 * 执行这些方法时 , 调用状态的相应方法
 */
public class VideoContext {

    /**
     * 当前的状态
     */
    private VideoState videoState;
    //状态类
    public static final VideoState STOP_STATE = new StopState();
    public static final VideoState PLAY_STATE = new PlayState();
    public static final VideoState PAUSE_STATE = new PauseState();
    public static final VideoState SPEED_STATE = new SpeedState();

    public VideoState getVideoState() {
        return videoState;
    }

    /**
     * 将传入的 VideoState , 赋值给当前的 VideoState videoState 成员
     *      除此之外 , 还要设置 VideoState 的上下文 , 即该类本身
     *      将当前的环境 VideoContext , 通知到各个状态实现类
     * @param videoState
     */
    public void setVideoState(VideoState videoState) {
        this.videoState = videoState;
        this.videoState.setVideoContext(this);
    }

    public void play(){
        this.videoState.play();
    }

    public void speed(){
        this.videoState.speed();
    }

    public void pause(){
        this.videoState.pause();
    }

    public void stop(){
        this.videoState.stop();
    }


}
