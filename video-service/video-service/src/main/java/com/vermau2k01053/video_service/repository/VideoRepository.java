package com.vermau2k01053.video_service.repository;

import com.vermau2k01053.video_service.document.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
}
