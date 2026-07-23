package com.finverse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finverse.dto.LoginRequest;
import com.finverse.dto.LoginResponse;
import com.finverse.dto.UserRegistrationRequest;
import com.finverse.entity.User;
import com.finverse.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody UserRegistrationRequest request) {

        User user = userService.register(request);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
           @RequestBody LoginRequest request){
         return ResponseEntity.ok(
              userService.login(request)
    );

}
}