package com.sparta.reviewassignment.comment.service;

import com.sparta.reviewassignment.comment.dto.CommentRequestDto;
import com.sparta.reviewassignment.comment.entity.Comment;
import com.sparta.reviewassignment.comment.repository.CommentRepository;
import com.sparta.reviewassignment.post.entity.Post;
import com.sparta.reviewassignment.post.repository.PostRepository;
import com.sparta.reviewassignment.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentService(CommentRepository commentRepository,PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void creatComment(Long id,CommentRequestDto commentRequestDto, User user) {
        Post post  = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 게시글이 없습니다"));
        Comment comment = new Comment(commentRequestDto);
        comment.setPost(post);

        commentRepository.save(comment);
    }
}
