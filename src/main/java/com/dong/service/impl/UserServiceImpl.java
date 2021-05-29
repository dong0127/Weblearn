package com.dong.service.impl;


import com.dong.dao.UserDao;
import com.dong.domain.UserBean;
import com.dong.service.UserService;
import com.dong.util.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    UserDao userDao = SqlSessionUtil.getSession().getMapper(UserDao.class);
    @Override
    public UserBean getUser(String id) {

        return userDao.getById(id);
    }
}
