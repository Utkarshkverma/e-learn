package com.vermau2k01053.video_service.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {
    @Id
    private String id;
    private String title;
    private String description;
    private String filePath;
    private String contentType;
    private String courseId;

}
