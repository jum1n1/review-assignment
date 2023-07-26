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

    // 닉네임과 같은 값이 포함된 경우 회원가입에 실패로 만들기 =>  service
    // 비밀번호 확인은 비밀번호와 정확하게 일치하기 =>  service
    // 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." =>  service
    // 라는 에러메세지를 response에 포함하기

    public void signup(SignupRequestDto signupRequestDto) {
        User user = new User(signupRequestDto);

        // 닉네임과 같은 값이 포함된 경우
        if (user.getPassword().matches(user.getNickName())) {
            throw new IllegalArgumentException("비밀번호를 닉네임과 다르게 입력해주세요.");
//            return ResponseEntity.badRequest().body(new MsgResponseDto("비밀번호를 닉네임과 다르게 입력해주세요."));
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

