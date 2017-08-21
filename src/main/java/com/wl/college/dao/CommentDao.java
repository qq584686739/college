package com.wl.college.dao;

import com.wl.college.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface CommentDao {
    Integer create(@Param("comment") Comment comment);

    Comment findById(@Param("id") Integer id);

    List<Comment> list(@Param("comment") Comment comment);

    Integer total(@Param("comment") Comment comment);

    Integer delete(@Param("id") Integer id);

    Integer update(@Param("comment") Comment comment);
}
