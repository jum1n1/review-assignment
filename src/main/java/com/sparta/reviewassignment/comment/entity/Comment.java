package com.sparta.reviewassignment.comment.entity;

import com.sparta.reviewassignment.comment.dto.CommentRequestDto;
import com.sparta.reviewassignment.post.entity.Post;
import com.sparta.reviewassignment.post.entity.TimeStamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="comments")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    public void setPost(Post post){
        this.post = post;
    }

    public Comment(CommentRequestDto commentRequestDto){
        this.title = commentRequestDto.getTitle();
        this.content = commentRequestDto.getContent();
    }
}
