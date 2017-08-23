package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.UserCollection;
import com.wl.college.service.UserCollectionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户收藏控制器
 * UserCollectionController
 * Created by XJH on 2017/8/23.
 */
@RequiresUser
@RestController
@RequestMapping("/collection")
public class UserCollectionController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private UserCollectionService userCollectionService;


    /**
     * user查询自己的收藏列表
     *
     * @param userCollection
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult list(
            @RequestParam(value = "userCollection", required = false) UserCollection userCollection,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
            @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {
        log.info("invoke----------/collection.GET");
        List<UserCollection> list = userCollectionService.list(
                (Integer) SecurityUtils.getSubject().getPrincipal(), userCollection, offset, limit, sort, order);
        return new BootStrapTableResult<>(0, list);
    }


    /**
     * 添加收藏
     * @param userCollection
     * @return
     */
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResult add(UserCollection userCollection){
        log.info("invoke----------/collection/add.GET");
        userCollectionService.add(userCollection);
        return new BaseResult<>(true, null);
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id){
        log.info("invoke----------/collection/delete/{" + id + "}.DELETE");
        userCollectionService.delete((Integer)SecurityUtils.getSubject().getPrincipal(), id);
        return new BaseResult<>(true, null);
    }
}
