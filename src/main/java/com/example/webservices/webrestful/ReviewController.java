package com.example.webservices.webrestful;

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
        System.out.println(id);
        return new ReviewBean(id,"5",false,false,false,false,"5",false,"5","5","5",false,false);
    }

}
