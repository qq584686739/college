package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Dept;
import com.wl.college.entity.Resource;
import com.wl.college.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by XJH on 2017/8/18.
 */
@RestController
@RequestMapping("/resources")
public class ResourceController {


    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Resource> create(Resource resource) {
        return new BaseResult<>(true, resourceService.create(resource));
    }

    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Resource> update(Resource resource) {
        return new BaseResult<>(true, resourceService.update(resource));
    }

    @DeleteMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id) {
        resourceService.delete(id);
        return new BaseResult(true,null );
    }
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Resource> list(Resource resource,
                                               @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
                                               @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
                                               @RequestParam(value = "sort", required = false, defaultValue = "id")String sort,
                                               @RequestParam(value = "order", required = false, defaultValue = "ASC")String order) {
        return new BootStrapTableResult<>(resourceService.total(resource), resourceService.list(resource,offset,limit,sort,order));
    }



}
