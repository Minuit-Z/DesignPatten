package proxy;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class Test {
    public static void main(String args[]){

//        Car car=new Car();
//        MyInvocationHandler handler=new MyInvocationHandler(car);
//        Class<? extends Car> aClass = car.getClass();
//
//        /**
//         * 代理对象也实现了接口,可以上转为Moveable类型
//         */
//        Moveable m = (Moveable) Proxy.newProxyInstance(aClass.getClassLoader(),
//                aClass.getInterfaces(), handler);
//
//        m.move();

//        HashMap m=new HashMap();
//        m.put(1,1);
//
//        Hashtable<String,String> table=new Hashtable<>();
////        table.put(null,"aaa0");
//        table.put("1","aaa1");
//        table.put("2","aaa2");
//
//        Enumeration<String> enu  = table.keys();
//        while (enu .hasMoreElements()){
//            System.out.println(table.keys()+"++++++"+enu.nextElement());
//        }
//
//        ConcurrentHashMap cm=new ConcurrentHashMap();

        Stack<String> integerStack=new Stack<>();
        integerStack.push("1");
        integerStack.push("2");
        integerStack.push("3");
        integerStack.push("4");
        integerStack.push("5");
        integerStack.push("6");
        integerStack.push("7");

        for (String s:integerStack){
            System.out.println(s);
        }

        integerStack.remove("6");
        for (String s:integerStack){
            System.out.println(s);
        }
    }
}
