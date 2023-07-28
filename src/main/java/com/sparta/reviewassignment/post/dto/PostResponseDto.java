package com.sparta.reviewassignment.post.dto;

import com.sparta.reviewassignment.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    // id이 선언은 엔티티에 하지만 ResponseDto에도 id 추가
    
    private Long id;
    private String title;
    private String nickName;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickName = post.getNickName();
        this.createAt = post.getCreateAt(); // 생성자에 포함안하면 null로 뜸
        this.modifiedAt = post.getModifiedAt();
    }
}
