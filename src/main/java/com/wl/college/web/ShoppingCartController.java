package com.wl.college.web;


import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Order;
import com.wl.college.entity.ShoppingCart;
import com.wl.college.service.ShoppingCartService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ShoppingCartController
 * Created by XJH on 2017/8/22.
 */
@RestController
@RequestMapping("/shopping/car/")
public class ShoppingCartController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    /**
     * 根据id得到一条购物车信息
     *
     * @param id
     * @return
     */
    @RequiresUser
    @GetMapping(value = "/findOne", produces = {"application/json;charset=UTF-8"})
    public BaseResult findOne(@RequestParam Integer id) {
        log.info("invoke----------/shopping/car/findOne.GET");
        return new BaseResult<>(true, shoppingCartService.findOne((Integer) SecurityUtils.getSubject().getPrincipal(), id));
    }


    /**
     * （当前用户）查看自己的购物车
     *
     * @param offset 起始位置
     * @param limit  需要数目
     * @param sort   排序字段
     * @param order  排序规则
     * @return BootStrapTableResult
     */
//    @RequiresUser
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult list(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
            @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {
        log.info("invoke----------/shopping/car/list.GET");
        Integer total = shoppingCartService.getTotal((Integer) SecurityUtils.getSubject().getPrincipal());
        List<ShoppingCart> list = shoppingCartService.list((Integer) SecurityUtils.getSubject().getPrincipal(),
                offset, limit, sort, order);
        return new BootStrapTableResult<>(total, list);
    }


    /**
     * （管理员）查看user的购物车
     *
     * @param id     user id
     * @param offset 起始位置
     * @param limit  需要数目
     * @param sort   排序字段
     * @param order  排序规则
     * @return BootStrapTableResult
     */
    @RequiresUser
    @GetMapping(value = "/userList", produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult userList(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
            @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {
        log.info("invoke----------/shopping/car/userList.GET");
        Integer total = shoppingCartService.getTotal(id);
        List<ShoppingCart> list = shoppingCartService.list(id, offset, limit, sort, order);
        return new BootStrapTableResult<>(total, list);
    }

    /**
     * 增加购物车
     *
     * @param shoppingCart
     * @return BaseResult
     */
    @RequiresUser
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResult add(@RequestParam ShoppingCart shoppingCart) {
        log.info("invoke----------/shopping/car/add.GET");
        Boolean shoppingCartIsExist = shoppingCartService.isExist(shoppingCart);
        if (shoppingCartIsExist) {
            return new BaseResult<>(false, "已经存在，不能添加！");     // TODO: 2017/8/22 错误代码
        }
        shoppingCartService.add(shoppingCart);
        return new BaseResult<>(true, null);
    }

    /**
     * 删除购物车一条记录
     *
     * @param id
     * @return
     */
    @RequiresUser
    @DeleteMapping(value = "/delete/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id) {
        log.info("invoke----------/shopping/car/delete{id}.DELETE");
        shoppingCartService.delete(id);
        return new BaseResult(true, null);
    }


    /**
     * 批量删除购物车
     *
     * @return
     */
    @RequiresUser
    @PostMapping(value = "/deleteSome", produces = {"application/json;charset=UTF-8"})
    public BaseResult deleteSome(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        log.info("invoke----------/shopping/car/deleteSome.POST");
        if (ids == null) {
            return new BaseResult(false, "数据不能为空");         // TODO: 2017/8/22 错误代码
        }
        shoppingCartService.deleteSome((Integer) SecurityUtils.getSubject().getPrincipal(), ids);
        return new BaseResult(true, null);
    }

    /**
     * 购物车生成订单（1个）
     *
     * @return
     */
    @RequiresUser
    @PostMapping(value = "/generate/order", produces = {"application/json;charset=UTF-8"})
    public BaseResult generateOrder(@RequestParam Integer id) {
        log.info("invoke----------/shopping/car/generate/order.POST");
        Order order = shoppingCartService.generateOrder((Integer) SecurityUtils.getSubject().getPrincipal(), id);
        return new BaseResult<>(true, order);
    }

    /**
     * 批量生成订单（多个）
     *
     * @return
     */
    @RequiresUser
    @PostMapping(value = "/generate/orders", produces = {"application/json;charset=UTF-8"})
    public BaseResult generateOrders(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        log.info("invoke----------/shopping/car/generate/orders.POST");
        List<Order> orders = shoppingCartService.generateOrders((Integer) SecurityUtils.getSubject().getPrincipal(), ids);
        return new BaseResult(true, orders);
    }


}
