package com.sparta.reviewassignment.post.service;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import com.sparta.reviewassignment.post.dto.PostResponseDto;
import com.sparta.reviewassignment.post.entity.Post;
import com.sparta.reviewassignment.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostResponseDto create(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
//        postRepository.save(post);
        return new PostResponseDto(postRepository.save(post));
    }
}