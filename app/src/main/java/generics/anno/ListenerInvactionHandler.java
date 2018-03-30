package generics.anno;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class ListenerInvactionHandler implements InvocationHandler {
    //被代理的真实对象的应用
    private Context context;
    //一个activity中可能存在多个点击的方法体
    private Map<String, Method> methodMap;


    public ListenerInvactionHandler(Context context, Map<String, Method> methodMap) {
        this.context = context;
        this.methodMap = methodMap;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //首先获取到方法名
        String name = method.getName();
        //根据方法名找方法,看是否需要代理
        Method metf = methodMap.get(name);

        if (metf != null) {
            //需要代理
            return metf.invoke(context, args);
        } else {
            return method.invoke(proxy, args);
        }
    }
}
