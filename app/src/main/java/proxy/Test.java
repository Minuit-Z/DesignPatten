package proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class Test {
    public static void main(){

        Car car=new Car();
        MyInvocationHandler handler=new MyInvocationHandler(car);
        Class<? extends Car> aClass = car.getClass();

        /**
         * 代理对象也实现了接口,可以上转为Moveable类型
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(), handler);

        m.move();
    }
}
