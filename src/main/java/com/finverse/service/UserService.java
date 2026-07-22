package com.finverse.service;

import com.finverse.dto.LoginRequest;
import com.finverse.dto.UserRegistrationRequest;
import com.finverse.entity.User;

public interface UserService {

    User register(UserRegistrationRequest request);

    User login(LoginRequest request);

}