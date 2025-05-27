package com.example.ridereviewservice.RideReviewService.repositories;

import com.example.ridereviewservice.RideReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

//    Raw sql query, if any error is there in the query then it will throw it only at the runtime
//    @Query(nativeQuery = true, value = "SELECT * FROM DRIVER WHERE id = :id AND license_number = :license")
//    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);

//    Hibernate query language, if any error is there in the query then it will throw error at compile time
//    @Query("SELECT d FROM Driver d WHERE d.id = :id And d.name = :name")
//    Optional<Driver> rawHQLFindByIdAndName(Long id, String name);

    List<Driver> findAllByIdIn(List<Long> id);
}
