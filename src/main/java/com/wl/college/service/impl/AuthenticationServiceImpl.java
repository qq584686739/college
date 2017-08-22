package com.wl.college.service.impl;

import com.wl.college.dao.AuthenticationDao;
import com.wl.college.dao.UserDao;
import com.wl.college.entity.Authentication;
import com.wl.college.entity.User;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationDao authenticationDao;
    protected final UserDao userDao;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationDao authenticationDao, UserDao userDao) {
        this.authenticationDao = authenticationDao;
        this.userDao = userDao;
    }

    @Override
    public Authentication create(Authentication authentication) {
        Integer insert = authenticationDao.create(authentication);
        if(insert!=1){
            throw  new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return authenticationDao.findById(authentication.getId());
    }

    @Transactional
    @Override
    public Authentication check(Integer id, String state) {
        Authentication authentication = new Authentication();
        authentication.setState(state);
        authentication.setId(id);
        Integer update = authenticationDao.update(authentication);
        if(state.equals("0")){
            Authentication byId = authenticationDao.findById(id);
            User user = new User();
            user.setBranch(byId.getBranch());
            user.setAddress(byId.getAddress());
            user.setTown(byId.getTown());
            user.setCity(byId.getCity());
            user.setBankCardFront(byId.getBankCardFront());
            user.setBankCard(byId.getBankCard());
            user.setBankCardBack(byId.getBankCardBack());
            user.setPhoto(byId.getPhoto());
            user.setIdCardWith(byId.getIdCardWith());
            user.setIdCard(byId.getIdCard());
            user.setIdCardBack(byId.getIdCardBack());
            user.setIdCardFront(byId.getIdCardFront());
            user.setFullName(byId.getFullName());
            userDao.update(user,byId.getUserId());
        }
        if(update!=1){
            throw  new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
        return authenticationDao.findById(id);
    }

    @Override
    public Integer total(Authentication authentication) {
        return authenticationDao.total(authentication);
    }

    @Override
    public List<Authentication> list(Authentication authentication, Integer offset, Integer limit, String sort, String order) {
        return authenticationDao.list(authentication,offset,limit,sort,order);
    }
}
