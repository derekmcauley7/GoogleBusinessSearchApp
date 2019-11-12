package com.example.webservices.webrestful;

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
    public Place create(@RequestParam("search") String search){
        ArrayList googleBusinessInfo = PlacesHelper.getPlaces(search);
        try {
            String id = googleBusinessInfo.get(0).toString();
            String name = googleBusinessInfo.get(1).toString();
            String rating = googleBusinessInfo.get(3).toString();
            String address = googleBusinessInfo.get(2).toString();
            String image = googleBusinessInfo.get(4).toString();
            return placeRepository.save(new Place(id, name, rating, address, image));
        } catch (Exception e) {
            System.out.println(e);
            return  null;
        }
    }

}
