package com.example.mytubebackend.user.controller;

import com.example.mytubebackend.user.domain.User;
import com.example.mytubebackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
//responsebody를 안달아도 string변환 가능 (<- api)
@RequiredArgsConstructor //매개변수가 있는 생성자 만들기
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody User user){
        System.out.println("email: " + user.getEmail());
        userService.joinUser(user);
        return "user";
    }

    @PostMapping("login")
    public User login(@RequestBody User user){
        User loginedUser = userService.loginUser(user);
        return loginedUser;
    }
}
