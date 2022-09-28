package com.example.mytubebackend.user.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primarykey
    private long id;

    //새로 sql에서 테이블을 만들때 명시하는 것일 뿐, 검증 로직 x
    @Column(unique = true, nullable = false) //not null + unique
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
