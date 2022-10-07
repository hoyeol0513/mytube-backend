package com.example.mytubebackend.user.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String email;
    private String username;

    //DTO = Data Transfer Object (데이터 전송 객체)
    //나가기 전에 한번 감싸면 됨.
}
