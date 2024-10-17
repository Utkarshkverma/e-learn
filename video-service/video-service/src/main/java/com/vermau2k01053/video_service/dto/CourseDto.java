package com.vermau2k01053.video_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
