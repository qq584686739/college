package com.wl.college.service;

import com.wl.college.entity.Resource;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface ResourceService {
    Resource create(Resource resource);

    void delete(Resource resource);

    Resource update(Resource resource);

    Integer total(Resource resource);

    List<Resource> list(Resource resource, Integer offset, Integer limit, String sort, String order);
}
