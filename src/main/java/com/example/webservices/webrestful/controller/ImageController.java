package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.Image;
import com.example.webservices.webrestful.Review;
import com.example.webservices.webrestful.User;
import com.example.webservices.webrestful.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/images")
    public List<Image> index(){
        return imageRepository.findAll();
    }

    @GetMapping("/allImages/{businessID}")
    public List<Image> search(@PathVariable String businessID){
        String businessId = businessID;
        return imageRepository.findByBusinessID(businessId);
    }

    @PostMapping("/image")
    public Image create(@RequestBody Map<String, String> body) {
        String url = body.get("url");
        String businessID = body.get("businessID");
        String userId = body.get("userId");
        return imageRepository.save(new Image(url, businessID, userId));
    }
}
