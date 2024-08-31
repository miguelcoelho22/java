package com.example.picpay.controller;

import com.example.picpay.domain.User;
import com.example.picpay.domain.UserDto;
import com.example.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto dto) {
        User user = userService.saveUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> showUser() {
        List<User> users = userService.showUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}