package com.example.user.service;

import lombok.RequiredArgsConstructor;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
