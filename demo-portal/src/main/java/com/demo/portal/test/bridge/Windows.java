package com.demo.portal.test.bridge;

public class Windows extends OperatingSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        super.getVideoFile().decode(fileName);
    }
}
