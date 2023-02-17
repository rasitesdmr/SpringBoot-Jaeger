package com.example.userservice.controller;

import com.example.userservice.request.UserCreateRequest;
import com.example.userservice.response.UserResponse;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    ResponseEntity<UserResponse> createUser(UserCreateRequest userCreateRequest) {
        return new ResponseEntity<>(userService.createUser(userCreateRequest), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public UserResponse getByUserId(@PathVariable("id") Long id) {
        return userService.getByUserId(id);
    }

}
