package com.vermau2k01053.category_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Category_Table")
public class Category {

    @Id
    private String id;

    @Column(nullable = true)
    private String title;

    private String description;

    private Date addedDate;
}
