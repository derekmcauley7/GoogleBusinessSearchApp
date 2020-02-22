package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.bean.Image;
import com.example.webservices.webrestful.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

        @GetMapping("/allImages/{placesId}")
    public List<Image> search(@PathVariable String placesId){
        return imageRepository.findByPlacesId(placesId);
    }

    @PostMapping("/image")
    public Image create(@RequestBody Map<String, String> body) {
        String url = body.get("url");
        String placesId = body.get("placesId");
        String userId = body.get("userId");
        return imageRepository.save(new Image(url, placesId, userId));
    }
}
