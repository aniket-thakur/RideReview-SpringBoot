package com.example.ridereviewservice.RideReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Passenger extends BaseModel {
    @Column(nullable = false)
    private String Name;
    @OneToMany(mappedBy = "passenger")
    List<Booking> bookings = new ArrayList<>();
}
