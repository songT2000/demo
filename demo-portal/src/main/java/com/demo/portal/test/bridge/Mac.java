package com.demo.portal.test.bridge;

public class Mac extends OperatingSystem{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        super.getVideoFile().decode(fileName);
    }
}
