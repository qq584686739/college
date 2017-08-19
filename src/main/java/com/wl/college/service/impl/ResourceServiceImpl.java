package com.wl.college.service.impl;

import com.wl.college.dao.ResourceDao;
import com.wl.college.entity.Resource;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    final ResourceDao resourceDao;

    @Autowired
    public ResourceServiceImpl(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }

    @Override
    public Resource create(Resource resource) {
        Integer integer = resourceDao.create(resource);
        if(integer!=1){
            throw  new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return resourceDao.findById(resource.getId());
    }

    @Override
    public void delete(Integer resource) {
        Integer delete = resourceDao.delete(resource);
        if(delete!=1){
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_ERROR);
        }
    }

    @Override
    public Resource update(Resource resource) {
        Integer update = resourceDao.update(resource);
        if(update!=1){
            throw new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
        return resourceDao.findById(resource.getId());
    }

    @Override
    public Integer total(Resource resource) {
        return resourceDao.total(resource);
    }

    @Override
    public List<Resource> list(Resource resource, Integer offset, Integer limit, String sort, String order) {
        return resourceDao.list(resource,offset,limit,sort,order);
    }
}
