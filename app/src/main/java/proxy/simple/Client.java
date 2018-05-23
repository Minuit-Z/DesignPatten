package proxy.simple;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class Client {
    public static void main(String args[]) {
        //构造真实对象
        RealSubject rSub = new RealSubject();

        ProxySubject pSub = new ProxySubject(rSub);

        pSub.visit();


        //动态代理

        //首先构造真实对象
        RealSubject realSubject = new RealSubject();
        //准备类加载器作为参数
        ClassLoader loader = realSubject.getClass().getClassLoader();
        //实例化代理,传入真实对象
        MyProxy myProxy = new MyProxy(realSubject);
        //创造代理对象, 通过Proxy.newProxyInstance构造
        RealSubject fakeSub = (RealSubject) Proxy.newProxyInstance(loader, realSubject.getClass().getInterfaces(), myProxy);

        //使用代理对象调用真实对象的方法
        fakeSub.visit();
    }
}
