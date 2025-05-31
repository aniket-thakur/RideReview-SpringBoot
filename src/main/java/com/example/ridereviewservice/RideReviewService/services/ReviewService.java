package com.example.ridereviewservice.RideReviewService.services;


import com.example.ridereviewservice.RideReviewService.models.Booking;
import com.example.ridereviewservice.RideReviewService.models.BookingStatus;
import com.example.ridereviewservice.RideReviewService.models.Driver;
import com.example.ridereviewservice.RideReviewService.models.Review;
import com.example.ridereviewservice.RideReviewService.repositories.BookingRepository;
import com.example.ridereviewservice.RideReviewService.repositories.DriverRepository;
import com.example.ridereviewservice.RideReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    ReviewRepository reviewRepository;
    BookingRepository bookingRepository;
    DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository
    ) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    //    public ReviewService(BookingRepository bookingRepository){
//        this.bookingRepository = bookingRepository;
//    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("checking....");

        Review rv = Review
                .builder()
                .content("First experience")
                .rating(4.0)
                .build();  // code to create plain java object

        Driver dr = Driver
                .builder()
                .name("Ana")
                .licenseNumber("HR56J34")
                .build();

        Booking bk = Booking
                .builder()
                .bookingStatus(BookingStatus.SCHEDULED)
                .startTime(new Date())
                .review(rv)
                .driver(dr)
                .build();


//        booking object depends on review, so create the review object and save it first then go
//        for saving the booking object

//        driverRepository.save(dr);
//        bookingRepository.save(bk);
//        reviewRepository.save(rv);

//        System.out.println(rv);



//        TO delete a record by id. since there is a foreign key constrain in booking table where it holds a foreign key of booking_review table,
//        and we set @Onetoone(cascade = cascadeType.REMOVE) on Booking table model. SO any records deleted from Booking table the corresponding
//        record will also be deleted
//        abd if we remove any record from

//        Optional<Booking> id = bookingRepository.findById(2L);
//        if(id.isPresent()){
//            bookingRepository.delete(id.get());

        //        TO fetch all records of content column
//        List<Review> reviews  = reviewRepository.findAll();
//        for(Review r : reviews){
//            System.out.println(r.getContent());
//        }
//        To delete a record
//        reviewRepository.deleteById(2L);

//   DRIVE FIND LOGIC
//        Optional<Driver> dd = driverRepository.findById(202L);
//        if(dd.isPresent()){
//            System.out.println("Inside Present");
//            List<Booking> driverBookings = dd.get().getBookings();
//            System.out.println(driverBookings);
//            for(Booking bok : driverBookings){
//                System.out.println(bok.getId());
//            }
//        }

//        FIND DRIVER WITH RAW QUERY
//        Optional<Driver> rawdriver = driverRepository.rawFindByIdAndLicenseNumber(202L, "HR56J34");
//        rawdriver.ifPresent(driver -> System.out.println("id = " + driver.getId()
//                + " Name: " + driver.getName()
//                + " License: " + driver.getLicenseNumber()));

//        FIND DRIVER USING HIBERNATE QUERY LANGUAGE (RAW)
//        Optional<Driver> hqldriver = driverRepository.rawHQLFindByIdAndName(202L, "Ana");
//        hqldriver.ifPresent(driver -> System.out.println("id = " + driver.getId()
//                + " Name: " + driver.getName()
//                + " License: " + driver.getLicenseNumber())
//        );
//        System.out.println("completed");



//        List<Booking> fdbks = bookingRepository.findAllByDriverId(2L);
//        System.out.println("checking join condition ");

//        for(Booking bk : fdbks){
//            System.out.println(bk.getBookingStatus());
//        }

        // creating a list of driver ids
        List<Long> drivers = new ArrayList<>(Arrays.asList(1L,12L,3L,17L,52L,152L,202L));
        List<Driver> driv = driverRepository.findAllByIdIn(drivers);
//        List<Booking> bookings = bookingRepository.findAllByDriverIn(driv);

//        driv.forEach(driverr ->System.out.println(driverr.getName()));
        for(Driver d : driv){
            List<Booking> bookings = d.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }


//        Find all review by driver ID;

        List<Review> review = driverRepository.findAllReviewByDriverId(2L);
        review.forEach(r -> System.out.println(r.getContent()));


    }
}








