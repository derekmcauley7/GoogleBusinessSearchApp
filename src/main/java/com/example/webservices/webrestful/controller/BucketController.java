package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.AmazonClient;
import com.example.webservices.webrestful.bean.Image;
import com.example.webservices.webrestful.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/storage/")
public class BucketController {

    @Autowired
    ImageRepository imageRepository;

    private AmazonClient amazonClient;

    @Autowired
    BucketController(   AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
        public String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam String placesId, @RequestParam String userId) {
        String url = this.amazonClient.uploadFile(file);
        Image image =  imageRepository.save(new Image(url, placesId, userId));
        if (url != null && image != null) {
            return "Image Uploaded!!!";
        } else {
            return "Sorry something went wrong";
        }
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

}