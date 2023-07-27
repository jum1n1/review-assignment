package com.sparta.reviewassignment.user.service;

import com.sparta.reviewassignment.user.dto.MsgResponseDto;
import com.sparta.reviewassignment.user.dto.SignupRequestDto;
import com.sparta.reviewassignment.user.entity.User;
import com.sparta.reviewassignment.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void signup(SignupRequestDto signupRequestDto) {
        User user = new User(signupRequestDto);

        // 닉네임과 같은 값이 포함된 경우 => 아에 같은 경우에만 체크함
        if (user.getPassword().contains(user.getNickName())) {
            throw new IllegalArgumentException("비밀번호를 닉네임과 다르게 입력해주세요.");
        }

        // 비밀번호 확인은 비밀번호와 정확하게 일치
        if (!user.getPassword().equals(user.getCheckPassword())) {
            throw new IllegalArgumentException("확인용 비밀번호와 비밀번호가 다릅니다.");
        }

        // 닉네임 중복 확인
        if (userRepository.findBynickName(user.getNickName()).isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        userRepository.save(user);
    }


}

