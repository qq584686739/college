package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Comment;
import com.wl.college.entity.Course;
import com.wl.college.entity.User;
import com.wl.college.service.CommentService;
import com.wl.college.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/19.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }


    /**
     * 添加评论（用户用）
     * @param comment
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Comment> create(Comment comment) {
        comment.setState("1");
        comment.setPid(null);
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        User user = userService.getUserByTag(id, null, null, null);
        comment.setDeptId(user.getDeptId());
        comment.setUserId(id);
        return new BaseResult<>(true, commentService.create(comment));
    }

    /**
     * 评论评论（管理员）
     * @param comment
     * @return
     */
    //TODO 需要权限
    @PostMapping(value = "/admin",produces = {"application/json;charset=UTF-8"})
    public BaseResult<Comment> adminCreate(Comment comment) {
        return new BaseResult<>(true, commentService.create(comment));
    }
      /**
     * 查看评论
     * @param comment
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Comment> list(Comment comment) {
        return new BootStrapTableResult<>(commentService.total(comment), commentService.list(comment));
    }

    /**
     * 查看评论（平台用）
     * @param comment
     * @return
     */
    @GetMapping(value = "/dept",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Comment> deptList(Comment comment) {
        comment.setDeptId((Integer) SecurityUtils.getSubject().getPrincipal());
        return new BootStrapTableResult<>(commentService.total(comment), commentService.list(comment));
    }

    /**
     * 查看评论（用户用）
     * @param comment
     * @return
     */
    @GetMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Comment> userList(Comment comment) {
        User user = userService.getUserByTag((Integer) SecurityUtils.getSubject().getPrincipal(), null, null, null);
        comment.setDeptId(user.getDeptId());
        return new BootStrapTableResult<>(commentService.total(comment), commentService.list(comment));
    }

    /**
     * 删课程
     *
     * @return
     */
    @DeleteMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id) {
        commentService.delete(id);
        return new BaseResult(true,null);
    }

}
