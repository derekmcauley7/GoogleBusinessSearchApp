package com.example.webservices.webrestful;

public class PlaceBean {
    private int id;
    private final String name;
    private final String address;
    private final String rating;
    private final String img;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

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
        return "Place       Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating='" + rating + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public PlaceBean(int id, String name, String address, String rating, String img) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.img = img;
    }

}
