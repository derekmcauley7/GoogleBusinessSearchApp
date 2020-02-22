package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.bean.Place;
import com.example.webservices.webrestful.PlacesHelper;
import com.example.webservices.webrestful.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/places")
    public List<Place> index(){
        return placeRepository.findAll();
    }

    @PostMapping("/place/search")
    public List<Place> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return placeRepository.findBynameContaining(searchTerm, searchTerm);
    }

    @GetMapping(path = "/place" )
    public Place create(@RequestParam("search") String search, @RequestParam("county") String county){
        ArrayList googleBusinessInfo = PlacesHelper.getPlaces(search, county);
        try {
            String id = googleBusinessInfo.get(0).toString();
            String name = googleBusinessInfo.get(1).toString();
            String rating = googleBusinessInfo.get(3).toString();
            String address = googleBusinessInfo.get(2).toString();
            String image = googleBusinessInfo.get(4).toString();
            return placeRepository.save(new Place(id, name, rating, address, image));
        } catch (Exception e) {
            System.out.println(e);
            return  placeRepository.save(new Place("1", "No Place Found", "0", "", "https://onlinezebra.com/wp-content/uploads/2019/01/error-404-not-found.jpg"));
        }
    }

}
