package proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class MyProxy implements InvocationHandler{

    private Object obj;

    public MyProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}
