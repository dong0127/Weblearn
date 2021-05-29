package com.dong.dao;

import com.dong.domain.UserBean;

public interface UserDao {

    UserBean getById(String id);
}
