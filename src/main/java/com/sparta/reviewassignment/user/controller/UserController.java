package com.sparta.reviewassignment.user.controller;

import com.sparta.reviewassignment.user.dto.LoginRequestDto;
import com.sparta.reviewassignment.user.dto.MsgResponseDto;
import com.sparta.reviewassignment.user.dto.SignupRequestDto;
import com.sparta.reviewassignment.user.jwt.JwtUtil;
import com.sparta.reviewassignment.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    public UserController(UserService userService,JwtUtil jwtUtil){
        this.userService = userService;
        this.jwtUtil = jwtUtil;
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

    @PostMapping("/login")
    public ResponseEntity<MsgResponseDto> login(@RequestBody LoginRequestDto loginRequestDto , HttpServletResponse res){

        try{
            userService.login(loginRequestDto);
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(new MsgResponseDto("닉네임 또는 패스워드를 확인해주세요."));
        }

        // JWT 토큰 만들기
        res.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(loginRequestDto.getNickName()));
        return ResponseEntity.ok().body(new MsgResponseDto("로그인 성공"));
    }


}

