package com.example.webservices.webrestful.repository;

import com.example.webservices.webrestful.bean.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String> {

    List<Place> findBynameContaining(String name, String nameAgain);

}
