package com.example.webservices.webrestful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  PlaceRepository extends JpaRepository<Place, String> {

    List<Place> findBynameContaining(String name, String nameAgain);

}
