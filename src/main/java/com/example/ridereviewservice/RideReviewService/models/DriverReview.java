package com.example.ridereviewservice.RideReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DriverReview extends Review{
    @Column(nullable = true)
    protected String driverReview;

}
