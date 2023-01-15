package com.example.user.service;

import com.example.user.domain.User;
import com.example.user.dto.UserDto;
import com.example.user.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import com.example.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

