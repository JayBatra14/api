package com.jay.api.controller;

import com.jay.api.entity.User;
import com.jay.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        //user.getLaptops().stream().forEach(laptop -> laptop.setUser(user));
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }

}
