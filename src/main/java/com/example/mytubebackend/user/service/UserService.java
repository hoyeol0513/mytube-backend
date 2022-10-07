package com.example.mytubebackend.user.service;

import com.example.mytubebackend.user.dao.UserRepository;
import com.example.mytubebackend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void joinUser(User user) {
        userRepository.save(user);
    }

    public User loginUser(User user) {
        Optional<User> targetUser = userRepository.findByEmail(user.getEmail());
        if(targetUser.isPresent()){
            System.out.println(targetUser.get());
            User loginedUser = targetUser.get();
            if(loginedUser.getPassword().equals(user.getPassword())){
                //문자열 비교는 equals, " == "은 객체의 주소를 비교함.
                return loginedUser;
            }
            return null;
        }
        return null;
    }
}
