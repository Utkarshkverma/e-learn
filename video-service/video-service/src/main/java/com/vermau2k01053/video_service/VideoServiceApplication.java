package com.vermau2k01053.video_service;

import com.vermau2k01053.video_service.document.Video;
import com.vermau2k01053.video_service.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class VideoServiceApplication {

	private final VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Video video = Video.builder() // Generate a random UUID for the ID
//				.title("Random Video Title")
//				.description("This is a randomly generated video description.")
//				.build();
//
//		// Save the video to the database
//		videoRepository.save(video);
//		System.out.println("Inserted Video: " + video);
//
//	}
}
