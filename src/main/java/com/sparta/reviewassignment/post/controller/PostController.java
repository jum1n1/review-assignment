package com.sparta.reviewassignment.post.controller;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import com.sparta.reviewassignment.post.dto.PostResponseDto;
import com.sparta.reviewassignment.post.service.PostService;
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
    public PostResponseDto create(@RequestBody PostRequestDto postRequestDto) {
        return postService.create(postRequestDto);
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
