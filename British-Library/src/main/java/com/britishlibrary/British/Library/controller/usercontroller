package com.britishlibrary.British.Library.controller;

import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @DeleteMapping("/id/{id}")
    public boolean deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return true;
    }
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable String id){
       return userService.getUserById(id);
    }
    @PutMapping("/id/{id}")
    public User updateUser(@PathVariable String id,@RequestBody User updateduser){
        User exisitnguser =userService.getUserById(id);
        if (exisitnguser == null){
            throw new RuntimeException("user not found"+ exisitnguser);
        }
        exisitnguser.setUserName(updateduser.getUserName());
        exisitnguser.setPassword(updateduser.getPassword());

        return userService.saveUser(exisitnguser);
    }


}
