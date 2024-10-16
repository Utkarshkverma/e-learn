package com.vermau2k01053.video_service.service.impl;

import com.vermau2k01053.video_service.document.Video;
import com.vermau2k01053.video_service.dto.VideoDto;
import com.vermau2k01053.video_service.exception.VideoNotFoundException;
import com.vermau2k01053.video_service.mapper.VideoMapper;
import com.vermau2k01053.video_service.repository.VideoRepository;
import com.vermau2k01053.video_service.service.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements IVideoService {

    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;


    @Override
    public VideoDto createVideo(VideoDto videoDto) {
        videoDto.setId(UUID.randomUUID().toString());
        Video video = videoMapper.dtoToEntity(videoDto);
        return videoMapper.entityToDto(videoRepository.save(video));
    }

    @Override
    public VideoDto updateVideo(String videoId, VideoDto videoDto) {
        Video video = videoRepository
                .findById(videoId)
                .orElseThrow(()-> new VideoNotFoundException("Video not found with id: " + videoId));
        video.setTitle(videoDto.getTitle());
        video.setDescription(videoDto.getDesc());
        video.setFilePath(videoDto.getFilePath());
        video.setContentType(videoDto.getContentType());
        video.setCourseId(videoDto.getCourseId());
        return null;
    }

    @Override
    public VideoDto getVideoById(String videoId) {
        Video video = videoRepository
                .findById(videoId)
                .orElseThrow(()-> new VideoNotFoundException("Video not found with id: " + videoId));
        return videoMapper.entityToDto(video);
    }

    @Override
    public Page<VideoDto> getAllVideos(Pageable pageable) {
        Page<Video> videos = videoRepository.findAll(pageable);
        List<VideoDto> dtos = videos.getContent()
                .stream()
                .map(videoMapper::entityToDto)
                .collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, videos.getTotalElements());
    }

    @Override
    public void deleteVideo(String videoId) {
     videoRepository.findById(videoId).ifPresentOrElse(videoRepository::delete, () -> {
         throw new VideoNotFoundException("Video not found with id: " + videoId);
     });
    }

    @Override
    public List<VideoDto> searchVideos(String keyword) {
        List<Video> videos = videoRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
        return videos.stream()
                .map(videoMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VideoDto saveVideoFile(MultipartFile file, String videoId) {
        return null;
    }

    @Override
    public List<VideoDto> getVideoOfCourse(String courseId) {
        return videoRepository
                .findByCourseId(courseId)
                .stream()
                .map(videoMapper::entityToDto).collect(Collectors.toList());
    }
}
