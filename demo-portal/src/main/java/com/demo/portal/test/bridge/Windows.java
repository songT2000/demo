package com.demo.portal.test.bridge;

/**
 *  具体实现化角色：鬼畜实现化角色接口的具体实现
 */
public class Windows extends OperatingSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        super.getVideoFile().decode(fileName);
    }
}
