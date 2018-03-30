package generics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import generics.anno.ConvertView;
import generics.anno.EventBase;
import generics.anno.ListenerInvactionHandler;
import generics.anno.ViewInject;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

/**
 * @author 张子扬
 * @time 2018/3/22 0022 18:14
 * @desc 第三方容器  完成注入
 */
public class InjectUtils {

    //注解只是起到一个标记的作用,用于标记,利用反射去找

    public static void inject(Context context) {
        //先注入视图,再注入控件
        injectLayout(context);
        injectView(context);
        injectEvents(context);
    }

    @SuppressLint("NewApi")
    private static void injectEvents(Context context) {
        Class<? extends Context> aClass = context.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        //遍历所有的方法并查找其注解
        for (Method m : declaredMethods) {

            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                //获取注解  annoType:OnClick
                Class<? extends Annotation> annoType = a.annotationType();
                //获取注解的值,onClick注解上面的EventBase
                EventBase base = annoType.getAnnotation(EventBase.class);
                if (null == base) {
                    continue; //跳出本轮循环
                }

                /**
                 *开始获取事件三要素 , 通过反射注入进去拿到真正的方法
                 */
                //1. 返回setOnclickListener字符串
                String listenerSetter = base.listenerSetter();
                //2. 返回View.OnClickListener字节码
                Class<?> listenerType = base.listenerType();
                //3. 返回onClick字符串
                String callMethod = base.callBackMethod();

                //方法名与方法的应映射
                Map<String, Method> methodMap = new HashMap<>();
                methodMap.put(callMethod, m);

                try {
                    //拿到注解中的value方法
                    Method value = annoType.getDeclaredMethod("value");
                    //对应value方法的返回值,这里通过反射是为了通用性,如果指定具体的类可以直接获取,但是扩展性很低
                    int[] ids = (int[]) value.invoke(a);

                    //注入事件
                    for (int viewId : ids) {
                        Method findv = aClass.getMethod("findViewById", int.class);
                        //通过反射拿到View
                        View view = (View) findv.invoke(context, viewId);
                        if (null == view) continue;

                        /**
                         * @Param listenerSetter: setOnClickListener的字符串,可以反射出方法
                         * @Param listenerType: 参数类型,为View.OnClickListener.class
                         */
                        Method setOnclick = view.getClass().getMethod(listenerSetter, listenerType);

                        ListenerInvactionHandler handler = new ListenerInvactionHandler(context, methodMap);
                        //设置返回对象的类型: proxyy是实现了OnclickListener接口,也就是listenerType接口的代理对象
                        Object proxy = Proxy.newProxyInstance(listenerType.getClassLoader(),
                                new Class[]{listenerType},
                                handler);

                        //利用代理设置监听
                        setOnclick.invoke(view,proxy);
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void injectLayout(Context context) {

        int layoutId = 0;
        Class clazz = context.getClass();

        //从注解出拿到注解中的值
        ConvertView view = (ConvertView) clazz.getAnnotation(ConvertView.class);

        if (null != view) {
            //从接口的value函数中获取
            try {
                layoutId = view.value();
                Method method = clazz.getMethod("setContentView", int.class);

                //拿到setContentView后调用函数
                method.invoke(context, layoutId);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void injectView(Context context) {

        Class<? extends Context> aClass = context.getClass();
        //获取到上下文中所有成员变量
        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field f : declaredFields) {
            //获取有注解的控件,注意注解之后没有加分号,意味着注解和类型声明是同一行语句
            ViewInject annotation = f.getAnnotation(ViewInject.class);

            if (null != annotation) {
                int value = annotation.value();

                try {

                    //调用了Activity的findViewById方法,context中没有该方法,需要反射获取
                    Method findViewById = aClass.getMethod("findViewById", int.class);

                    View view = (View) findViewById.invoke(context, value);
                    //允许反射私有变量
                    f.setAccessible(true);
                    //为反射到的变量赋值
                    f.set(context, view);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
