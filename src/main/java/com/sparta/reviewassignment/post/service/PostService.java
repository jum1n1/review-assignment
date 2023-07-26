package com.sparta.reviewassignment.post.service;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import com.sparta.reviewassignment.post.dto.PostResponseDto;
import com.sparta.reviewassignment.post.entity.Post;
import com.sparta.reviewassignment.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostResponseDto create(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        return new PostResponseDto(postRepository.save(post));
    }

    public List<PostResponseDto> read() {
           return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    @Transactional
    public PostResponseDto update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow();
        post.update(postRequestDto);
        return new PostResponseDto(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }
}
