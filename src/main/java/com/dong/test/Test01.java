package com.dong.test;

import com.dong.domain.UserBean;
import com.dong.service.UserService;
import com.dong.service.impl.UserServiceImpl;
import com.dong.util.Factory;



import java.io.IOException;
import java.io.InputStream;
public class Test01 {
    public static void main(String[] args) throws IOException {
        UserService userService = (UserService) Factory.getService(new UserServiceImpl());
        userService.getUser("4019243");
        /*SqlSession session = SqlSessionUtil.getSession();
        UserBean userBean = session.selectOne("test01.getById","4019243");

        SqlSessionUtil.closeSession(session);*/
    }
}
