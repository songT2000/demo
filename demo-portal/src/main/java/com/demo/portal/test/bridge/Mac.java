package com.demo.portal.test.bridge;

/**
 *  具体实现化角色：鬼畜实现化角色接口的具体实现
 */
public class Mac extends OperatingSystem{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        super.getVideoFile().decode(fileName);
    }
}
