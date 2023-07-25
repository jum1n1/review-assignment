package com.sparta.reviewassignment.post.repository;

import com.sparta.reviewassignment.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
