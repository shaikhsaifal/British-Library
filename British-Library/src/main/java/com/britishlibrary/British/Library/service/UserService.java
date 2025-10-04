package com.britishlibrary.British.Library.service;

import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void saveNewAdmin(User user){
        user.setRoles(Arrays.asList("ADMIN","USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User saveUser(User user){
        // if roles not set, default to USER
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Arrays.asList("USER"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean deleteUserById(String id){
        userRepository.deleteById(id);
        return true;
    }

    public User findbyUsername(String userName){
        return userRepository.findByUserName(userName).orElse(null);
    }

    public User deletebyUsername(String userName){
        return userRepository.deleteByUserName(userName);
    }
}



