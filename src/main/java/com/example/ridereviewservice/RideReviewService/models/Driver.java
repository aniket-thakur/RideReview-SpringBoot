package com.example.ridereviewservice.RideReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String licenseNumber;

//    A driver can have many bookings
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();


}
