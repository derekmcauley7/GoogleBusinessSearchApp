package com.example.webservices.webrestful;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="rating")
    private String rating;
    @Column(name="image")
    private String image;

    public Place() {  }

    public Place(String id, String name, String rating, String address, String image) {
        this.setId(id);
        this.setName(name);
        this.setRating(rating);
        this.setAddress(address);
        this.setImage(image);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
