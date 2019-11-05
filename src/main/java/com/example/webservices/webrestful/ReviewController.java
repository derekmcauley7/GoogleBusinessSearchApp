package com.example.webservices.webrestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200")

public class ReviewController {


    @CrossOrigin
    @GetMapping(path = "/review/{id}")
        public ReviewBean helloWordBean(@PathVariable("id") String id){
        ReviewBean reviewBean = new ReviewBean(id,"4","5","no","yes","no","yes","yes","0","no","5","5","5","yes","ys");
        return reviewBean;
    }

}
