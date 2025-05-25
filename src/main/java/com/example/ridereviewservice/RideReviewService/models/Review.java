package com.example.ridereviewservice.RideReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_review" ) // db table name
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {
    @Column(nullable = false)
    private String content;
    private Double rating;


}

/*
    In Inheritance we have
    1. MappedSuperClass
    2. Table per class
    3. Single Table
    4. Joined Table
 */