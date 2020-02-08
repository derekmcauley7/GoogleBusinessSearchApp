package com.example.webservices.webrestful.controller;
import com.example.webservices.webrestful.User;
import com.example.webservices.webrestful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> index(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        String userId = id;
        return userRepository.findOne(userId);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        String name = body.get("name");
        User user = userRepository.findOne(id);
        if(user != null) {
            return user;
        }
        return userRepository.save(new User(id, name, false ));
    }
}
