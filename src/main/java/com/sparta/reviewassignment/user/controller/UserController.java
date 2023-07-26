package com.sparta.reviewassignment.user.controller;

import com.sparta.reviewassignment.user.dto.MsgResponseDto;
import com.sparta.reviewassignment.user.dto.SignupRequestDto;
import com.sparta.reviewassignment.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MsgResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        try{
            userService.signup(signupRequestDto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new MsgResponseDto("로그인 정보를 다시 확인 해주세요."));
        }
        return ResponseEntity.ok().body(new MsgResponseDto("회원 가입 성공!"));
    }


}

