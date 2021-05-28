package com.dong.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;

/**
 * @author dong.hao2
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    /**
     * 保证其他类只能通过类来调用静态方法,避免创建没用的对象.
     */
    private SqlSessionUtil() {
    }

    static{
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = factory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    public static void closeSession(SqlSession session){
        if (session != null) {
            session.close();
            threadLocal.remove();
        }

    }
}
