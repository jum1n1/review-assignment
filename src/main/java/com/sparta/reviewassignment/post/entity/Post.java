package com.sparta.reviewassignment.post.entity;

import com.sparta.reviewassignment.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "posts")
@NoArgsConstructor // 생성자를 만들면 기본 생성자가 사라지기 떄문에 추가해줘야함
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
