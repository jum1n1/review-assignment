package com.sparta.reviewassignment.post.dto;

import com.sparta.reviewassignment.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    // id이 선언은 엔티티에 하지만 ResponseDto에도 id 추가
    
    private Long id;
    private String name;
    private String password;
    private String nickName;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.name = post.getName();
        this.password = post.getPassword();
        this.nickName = post.getNickName();
    }
}
