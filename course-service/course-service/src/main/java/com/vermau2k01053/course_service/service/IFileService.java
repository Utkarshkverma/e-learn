package com.vermau2k01053.course_service.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {


    String save(MultipartFile file, String outputPath, String filename) throws IOException;

}
