package com.britishlibrary.British.Library.controller;

import com.britishlibrary.British.Library.entity.User;

import com.britishlibrary.British.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}

