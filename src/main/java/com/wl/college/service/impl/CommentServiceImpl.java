package com.wl.college.service.impl;

import com.wl.college.dao.CommentDao;
import com.wl.college.entity.Comment;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Comment create(Comment comment) {
        Integer insert = commentDao.create(comment);
        if(insert!=1){
            throw  new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return commentDao.findById(comment.getId());
    }

    @Override
    public List<Comment> list(Comment comment) {
        return commentDao.list(comment);
    }

    @Override
    public Integer total(Comment comment) {
        return commentDao.total(comment);
    }

    @Override
    public void delete(Integer id) {
        Integer delete = commentDao.delete(id);
        if(delete!=1){
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_ERROR);
        }
    }
}
