package com.vermau2k01053.course_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    private String id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String shortDesc;
    @Column(length = 2000)
    private String longDesc;
    private double price;
    private boolean live = false;
    private double discount;
    private Date createdDate;
    private String banner;
    private String bannerContentType;
    private String categoryId;
}
