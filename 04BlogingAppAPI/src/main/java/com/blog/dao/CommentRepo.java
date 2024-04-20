package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.blog.models.Comment;

@Component
public interface CommentRepo  extends JpaRepository<Comment, Integer>{

}
