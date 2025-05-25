package com.example.ridereviewservice.RideReviewService.repositories;

import com.example.ridereviewservice.RideReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
