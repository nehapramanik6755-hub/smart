

package com.travelguide.demo.controller;

import com.travelguide.demo.entity.user;
import com.travelguide.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register")
    public user registerUser(@RequestBody user user) {
        return userService.registerUser(user);
    }

    
    @PostMapping("/login")
    public user login(@RequestBody user loginUser) {
        return userService.loginUser(
                loginUser.getEmail(),
                loginUser.getPassword()
        );
    }
}
