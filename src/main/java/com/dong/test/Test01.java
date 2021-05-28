package com.dong.test;

import com.dong.domain.UserBean;
import com.dong.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
public class Test01 {
    public static void main(String[] args) throws IOException {

        SqlSession session = SqlSessionUtil.getSession();
        UserBean userBean = session.selectOne("test01.getById","4019243");

        SqlSessionUtil.closeSession(session);
    }
}
