package com.example.webservices.webrestful;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200")
public class PlaceController {

    @CrossOrigin
    @GetMapping(path = "/place" )
    public PlaceBean helloWordBean(@RequestParam("search") String search){
        PlaceBean place;
        ArrayList googleBusinessInfo = PlacesHelper.getPlaces(search);
        try {
            place = new PlaceBean(googleBusinessInfo.get(0).toString(), googleBusinessInfo.get(1).toString(),
                    googleBusinessInfo.get(2).toString(), googleBusinessInfo.get(3).toString(), googleBusinessInfo.get(4).toString());
            return place;
        } catch (Exception e) {
            place = new PlaceBean("0", "No Listing Found",
                    "", "","");
            return place;
        }
    }

}
