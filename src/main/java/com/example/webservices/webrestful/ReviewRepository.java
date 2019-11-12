package com.example.webservices.webrestful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

        // custom query to search to review post by placeId
        List<Review> findByplacesIdContainingOrContentContaining(String placesId, String placesIdAgain);

    }
