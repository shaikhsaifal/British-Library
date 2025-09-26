package com.britishlibrary.British.Library.service;

import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //save a user
    public User saveUser(User user){
       return userRepository.save(user);
    }
    //Get users
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    //Get user by Id
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    //Delete user
    public boolean deleteUser(String id){
        userRepository.deleteById(id);
        return true;
    }
    //find by username
    public User findbyUsername(String userName){
        return userRepository.findByUserName(userName).orElse(null);
    }



}
