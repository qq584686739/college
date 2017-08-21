package com.wl.college.service;

import com.wl.college.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface CommentService {
    Comment create(Comment comment);

    List<Comment> list(Comment comment);

    Integer total(Comment comment);

    void delete(Integer id);

    Comment update(@Param("comment") Comment comment);
}
