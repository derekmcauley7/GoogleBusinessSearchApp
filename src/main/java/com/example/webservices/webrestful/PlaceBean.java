package com.example.webservices.webrestful;

public class PlaceBean {
    private final String id;
    private final String name;
    private final String address;
    private final String rating;
    private final String img;

    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public String getaddress() {
        return address;
    }

    public String getRating(){
        return rating;
    }

    public String getImg() {return  img; }

    @Override
    public String toString() {
        return "Place       Bean [ {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating='" + rating + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public PlaceBean(String id, String name, String address, String rating, String img) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.img = img;
    }

}
