package com.example.webservices.webrestful.repository;

import com.example.webservices.webrestful.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    // custom query to search to review post by placeId
    List<User> findByid(String id);

    // custom query to search to review post by placeId
    List<User> findBynameContaining(String id, String idAgain);

}
