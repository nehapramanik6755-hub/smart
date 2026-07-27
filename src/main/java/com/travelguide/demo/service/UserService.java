
package com.travelguide.demo.service;

import com.travelguide.demo.entity.user;
import com.travelguide.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   @Autowired
     private PasswordEncoder passwordEncoder;


    public user registerUser(user user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
}

   
    public user loginUser(String email, String password) {

        user existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (!passwordEncoder.matches(password, existingUser.getPassword())) {
         throw new RuntimeException("Invalid Password");
         }

        return existingUser;
    }
}