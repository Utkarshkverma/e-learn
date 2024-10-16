package com.vermau2k01053.video_service.service;

import com.vermau2k01053.video_service.dto.VideoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IVideoService {
    VideoDto createVideo(VideoDto videoDto);
    VideoDto updateVideo(String videoId, VideoDto videoDto);
    VideoDto getVideoById(String videoId);
    Page<VideoDto> getAllVideos(Pageable pageable);
    void deleteVideo(String videoId);
    List<VideoDto> searchVideos(String keyword);
    VideoDto saveVideoFile(MultipartFile file, String videoId);
    List<VideoDto> getVideoOfCourse(String courseId);
}
