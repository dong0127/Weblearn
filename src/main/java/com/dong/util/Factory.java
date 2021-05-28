package com.dong.util;

/**
 * @author dong.hao2
 */
public class Factory {
    public static Object getService(Object object){
        return new ProxyInvocationHandler(object).getProxy();
    }
}
