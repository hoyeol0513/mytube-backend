package com.example.mytubebackend.user.service;

import com.example.mytubebackend.user.dao.UserRepository;
import com.example.mytubebackend.user.domain.User;
import com.example.mytubebackend.user.dto.UserDto;
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

    public UserDto loginUser(User user) throws Exception {
        Optional<User> targetUser = userRepository.findByEmail(user.getEmail());
        if(targetUser.isPresent()){
            System.out.println(targetUser.get());
            User loginedUser = targetUser.get();
            if(loginedUser.getPassword().equals(user.getPassword())){ //문자열 비교는 equals, " == "은 객체의 주소를 비교함.
                UserDto userDto = new UserDto(); //엔티티를 그대로 내보내는건 안좋음 => DTO로 감싸서 내보내기
                //보내면 안되는 정보인 password는 빼고 보내기
                userDto.setId(loginedUser.getId());
                userDto.setEmail(loginedUser.getEmail());
                userDto.setUsername(loginedUser.getUsername());
                return userDto;
            }
            throw new Exception();
        }
        throw new Exception();
    }
}
