package com.sparta.reviewassignment.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
