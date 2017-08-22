package com.wl.college.service;

import com.wl.college.entity.Authentication;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
public interface AuthenticationService
{
    Authentication create(Authentication authentication);

    Authentication check(Integer id, String state);

    Integer total(Authentication authentication);

    List<Authentication> list(Authentication authentication, Integer offset, Integer limit, String sort, String order);
}
