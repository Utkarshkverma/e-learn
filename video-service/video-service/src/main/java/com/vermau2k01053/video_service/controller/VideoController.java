package com.vermau2k01053.video_service.controller;

import com.vermau2k01053.video_service.dto.VideoDto;
import com.vermau2k01053.video_service.service.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final IVideoService videoService;

    @PostMapping
    public ResponseEntity<VideoDto> createVideo(@RequestBody VideoDto videoDto) {
        return ResponseEntity.ok(videoService.createVideo(videoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoDto> updateVideo(@PathVariable String id, @RequestBody VideoDto videoDto) {
        return ResponseEntity.ok(videoService.updateVideo(id, videoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable String id) {
        return ResponseEntity.ok(videoService.getVideoById(id));
    }

    @GetMapping
    public ResponseEntity<Page<VideoDto>> getAllVideos(Pageable pageable) {
        return ResponseEntity.ok(videoService.getAllVideos(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable String id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<VideoDto>> searchVideos(@RequestParam String keyword) {
        return ResponseEntity.ok(videoService.searchVideos(keyword));
    }

    @GetMapping("/course/{courseId}")
    public List<VideoDto> getAllVideosOfCourse(@PathVariable String courseId) {
        return this.videoService.getVideoOfCourse(courseId);
    }


}
