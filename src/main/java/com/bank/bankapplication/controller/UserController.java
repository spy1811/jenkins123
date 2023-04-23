package com.bank.bankapplication.controller;

import com.bank.bankapplication.entity.UserOld;
import com.bank.bankapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserOld addUser(@RequestBody UserOld user){
        return userService.saveUser(user);

    }

    @PutMapping("/updateUser")
    public UserOld updateUser(@RequestBody UserOld user){
        return userService.updateUser(user);
    }

    @GetMapping("/getUser/{username}")
    public UserOld getUser(@PathVariable String username){
        return userService.getUsername(username);
    }

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/show-hello")
    public ResponseEntity<String> showHello(){
        return ResponseEntity.ok("Hello Spring Boot");
    }
}
