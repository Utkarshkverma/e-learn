package com.vermau2k01053.video_service.exception;

public class VideoNotFoundException extends RuntimeException {

    String id;
    public VideoNotFoundException(String id) {
        super(String.format("Course with id %s not found", id));
    }
}
