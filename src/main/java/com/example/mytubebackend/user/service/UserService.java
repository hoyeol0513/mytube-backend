package com.example.mytubebackend.user.service;

import com.example.mytubebackend.user.dao.UserRepository;
import com.example.mytubebackend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void joinUser(User user) {
        userRepository.save(user);
    }
}
