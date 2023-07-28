package com.sparta.reviewassignment.post.controller;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import com.sparta.reviewassignment.post.dto.PostResponseDto;
import com.sparta.reviewassignment.post.service.PostService;
import com.sparta.reviewassignment.user.dto.MsgResponseDto;
import com.sparta.reviewassignment.user.security.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<MsgResponseDto> create(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        try{
            postService.create(postRequestDto,userDetails.getUser());
            return ResponseEntity.ok().body(new MsgResponseDto("게시글 생성 완료!"));
        } catch (NullPointerException e){ // NullPointerException 라는 exception 이 발생할 경우 실행
            return ResponseEntity.badRequest().body(new MsgResponseDto("로그인 후 시도해주세요"));
        }

    }

    @GetMapping("/posts")
    public List<PostResponseDto> read(){
        return postService.read();
    }

    @PutMapping("/posts/{id}")
    public PostResponseDto update(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        return postService.update(id, postRequestDto);
    }

    @DeleteMapping("/posts/{id}")
    public String delete(@PathVariable Long id){
        postService.delete(id);
        return "삭제완료!";
    }
}
