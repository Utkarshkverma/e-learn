package com.vermau2k01053.course_service.service.impl;

import com.vermau2k01053.course_service.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements IFileService {
    @Override
    public String save(MultipartFile file, String outputPath, String filename) throws IOException {
        Path path = Paths.get(outputPath);
        Files.createDirectories(path);
        Path filePath = Paths.get(path.toString(), file.getOriginalFilename());
        System.out.println(filePath);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }
}
