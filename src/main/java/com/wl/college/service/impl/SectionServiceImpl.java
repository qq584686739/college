package com.wl.college.service.impl;

import com.wl.college.dao.SectionDao;
import com.wl.college.entity.Section;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
@Service
public class SectionServiceImpl implements SectionService{
    private final SectionDao sectionDao;

    @Autowired
    public SectionServiceImpl(SectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }

    @Override
    public Section create(Section section) {
        Integer create = sectionDao.create(section);
        if(create!=1){
            throw  new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return sectionDao.findById(section.getId());
    }

    @Override
    public Section update(Section section) {
        Integer update = sectionDao.update(section);
        if(update!=1){
            throw  new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
        return sectionDao.findById(section.getId());
    }

    @Override
    public void delete(Section section) {
        Integer delete = sectionDao.delete(section);
        if(delete!=1){
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_ERROR);
        }
    }

    @Override
    public List<Section> list(Section section) {
        return  sectionDao.list(section);
    }

    @Override
    public Integer total(Section section) {
        return  sectionDao.total(section);
    }
}
