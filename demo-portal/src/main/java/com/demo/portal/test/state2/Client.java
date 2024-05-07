package com.demo.portal.test.state2;

public class Client {

    public static void main(String[] args) {

        VideoContext videoContext = new VideoContext();

        videoContext.setVideoState(VideoContext.PLAY_STATE);
        System.out.println("视频状态:" + videoContext.getVideoState().getClass().getSimpleName());
        videoContext.pause();
        System.out.println("视频状态:" + videoContext.getVideoState().getClass().getSimpleName());
        videoContext.stop();
        System.out.println("视频状态:" + videoContext.getVideoState().getClass().getSimpleName());
        videoContext.speed();
        System.out.println("视频状态:" + videoContext.getVideoState().getClass().getSimpleName());
        videoContext.play();
        System.out.println("视频状态:" + videoContext.getVideoState().getClass().getSimpleName());

    }
}
