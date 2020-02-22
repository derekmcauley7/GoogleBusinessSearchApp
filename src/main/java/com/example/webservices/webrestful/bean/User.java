package com.example.webservices.webrestful.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="banned")
    private boolean banned;

    public User() { }


    public User(String id, String name, boolean banned) {
        this.setId(id);
        this.setName(name);
        this.setBanned(banned);
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

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
