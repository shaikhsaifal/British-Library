package com.britishlibrary.British.Library.service;

import com.britishlibrary.British.Library.entity.User;   // your entity
import com.britishlibrary.British.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch from DB
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Convert roles list to array
        String[] roles = (user.getRoles() != null && !user.getRoles().isEmpty())
                ? user.getRoles().toArray(new String[0])
                : new String[]{"USER"};

        // Return Spring Security's UserDetails object
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword()) // must already be encoded
                .roles(roles)
                .build();
    }
}
