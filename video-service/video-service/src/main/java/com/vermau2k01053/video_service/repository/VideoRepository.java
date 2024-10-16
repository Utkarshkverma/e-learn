package com.vermau2k01053.video_service.repository;

import com.vermau2k01053.video_service.document.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
    List<Video> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
    List<Video> findByCourseId(String courseId);
}
