package com.sparta.reviewassignment.post.entity;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String password;
    private String nickName;

    public Post(PostRequestDto postRequestDto){
        this.name = postRequestDto.getName();
        this.password = postRequestDto.getPassword();
        this.nickName = postRequestDto.getNickName();
    }

}
