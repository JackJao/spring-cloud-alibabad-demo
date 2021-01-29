package org.example.controller;

import org.example.domain.User;
import org.example.openfeign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private UserClient userClient ;

    @GetMapping("/order/{id}")
    public User getById(@PathVariable Long id){
        return userClient.getById(id);
    }
}