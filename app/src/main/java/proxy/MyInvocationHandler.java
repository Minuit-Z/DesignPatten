package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class MyInvocationHandler implements InvocationHandler{

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    //代理方法执行时,执行该方法

    /**
     * @param proxy 被代理对象
     * @param method 被代理对象的方法
     * @param args 被代理方法的参数
     * @return 方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method为被代理的方法
        Object result=method.invoke(target,args);
        return result;
    }
}
