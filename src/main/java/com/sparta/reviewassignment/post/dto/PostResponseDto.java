package com.sparta.reviewassignment.post.dto;

import com.sparta.reviewassignment.comment.dto.CommentResponseDto;
import com.sparta.reviewassignment.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class PostResponseDto {
    // id이 선언은 엔티티에 하지만 ResponseDto에도 id 추가
    
    private Long id;
    private String title;
    private String nickName;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private List<CommentResponseDto> comments;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickName = post.getNickName();
        this.createAt = post.getCreateAt();
        this.modifiedAt = post.getModifiedAt();
        this.comments = post.getCommentList().stream()
                .map(CommentResponseDto::new)
                .sorted(Comparator.comparing(CommentResponseDto::getCreateAt).reversed()) // 작성날짜 내림차순
                .toList();
    }
}
