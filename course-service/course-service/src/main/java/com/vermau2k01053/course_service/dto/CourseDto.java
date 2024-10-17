package com.vermau2k01053.course_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String id;
    private String title;
    private String shortDesc;
    @JsonProperty("long_description")
    private String longDesc;
    private double price;
    private boolean live;
    private double discount;
    private Date createdDate;
    private String banner;
    private String categoryId;
    private CategoryDto category;
    private List<VideoDto> videos;
}
