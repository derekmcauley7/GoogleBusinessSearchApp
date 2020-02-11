package com.example.webservices.webrestful.repository;

import com.example.webservices.webrestful.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

    List<Image> findByBusinessID(String businessId);
}
