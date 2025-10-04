package com.britishlibrary.British.Library.controller;

import com.britishlibrary.British.Library.entity.User;   // ✅ use your entity here
import com.britishlibrary.British.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create-new-admin")
    public void createNewAdmin(@RequestBody User user){
        userService.saveNewAdmin(user);
    }
}
