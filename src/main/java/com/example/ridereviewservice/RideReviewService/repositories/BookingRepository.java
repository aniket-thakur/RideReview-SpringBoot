package com.example.ridereviewservice.RideReviewService.repositories;

import com.example.ridereviewservice.RideReviewService.models.Booking;
import com.example.ridereviewservice.RideReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findAllByDriverId(Long id);

    List<Booking> findAllByDriverIn(List<Driver> drivers);
}
