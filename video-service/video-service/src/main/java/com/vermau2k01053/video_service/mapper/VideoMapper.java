package com.vermau2k01053.video_service.mapper;

import com.vermau2k01053.video_service.document.Video;
import com.vermau2k01053.video_service.dto.VideoDto;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {

    public Video dtoToEntity(VideoDto dto) {
        Video video = new Video();
        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDesc());
        video.setContentType(dto.getContentType());
        video.setFilePath(dto.getFilePath());
        video.setCourseId(dto.getCourseId());

        return video;
    }

    public VideoDto entityToDto(Video video) {
        VideoDto videoDto = new VideoDto();
        videoDto.setId(video.getId());
        videoDto.setTitle(video.getTitle());
        videoDto.setDesc(video.getDescription());
        videoDto.setContentType(video.getContentType());
        videoDto.setFilePath(video.getFilePath());
        videoDto.setCourseId(video.getCourseId());
        return videoDto;
    }
}
