package com.example.webservices.webrestful;

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
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/review")
    public List<Review> index(){
        return reviewRepository.findAll();
    }

    @GetMapping("/review/{id}")
    public Review show(@PathVariable String id){
        String placesId = id;
        return reviewRepository.findOne(placesId);
    }
    @PostMapping("/review/search")
    public List<Review> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return reviewRepository.findByplacesIdContainingOrContentContaining(searchTerm, searchTerm);
    }

    @GetMapping("/reviews")
    public List<Review> search(@RequestParam("placesId") String placesId){
        return reviewRepository.findByplacesId(placesId);
    }

    @PostMapping("/review")
    public Review create(@RequestBody Map<String, String> body) {
        String placesId = body.get("placesId");
        String userId = body.get("userId");
        String overAllRating = "0";
        String entrance = body.get("entrance");
        String toilet = body.get("toilet");
        String cleanliness = body.get("cleanliness");
        String areAllAreasAccessible = body.get("areAllAreasAccessible");
        String easeOfMovement = body.get("easeOfMovement");
        String seatingSuitability = body.get("seatingSuitability");
        String lift = body.get("lift");
        String stairs = body.get("stairs");
        String fullWheelchairAccessibleManual = body.get("fullWheelchairAccessibleManual");
        String fullWheelchairAccessibleElectric = body.get("fullWheelchairAccessibleElectric");
        String keyRequiredFromStaff = body.get("keyRequiredFromStaff");
        String serviceCounter = body.get("serviceCounter");
        String tableService = body.get("tableService");
        String content = body.get("content");

        return reviewRepository.save(new Review(placesId, overAllRating, userId, entrance, toilet, cleanliness, areAllAreasAccessible, easeOfMovement,
                seatingSuitability, lift, stairs, fullWheelchairAccessibleManual, fullWheelchairAccessibleElectric, keyRequiredFromStaff, serviceCounter,
                tableService, content));
    }

}
