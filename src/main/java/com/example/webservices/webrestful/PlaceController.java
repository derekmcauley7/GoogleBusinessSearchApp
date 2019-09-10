package com.example.webservices.webrestful;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@CrossOrigin("http://localhost:4200")
public class PlaceController {

    @CrossOrigin
    @GetMapping(path = "/place" )
    public PlaceBean helloWordBean(@RequestParam("search") String search){
        Random ran = new Random();
        ArrayList googleBusinessInfo = PlacesHelper.getPlaces(search);
        return new PlaceBean(1, googleBusinessInfo.get(0).toString(), googleBusinessInfo.get(1).toString(),
                googleBusinessInfo.get(2).toString(), googleBusinessInfo.get(3).toString());
    }

}
