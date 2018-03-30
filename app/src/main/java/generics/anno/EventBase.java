package generics.anno;

/**
 * Created by Administrator on 2018/3/26 0026.
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 提供事件三要素,对所有事件点击进行扩展
 */

@Retention(RetentionPolicy.RUNTIME)
//用于注解上的注解
@Target(ElementType.ANNOTATION_TYPE)
public @interface EventBase {

    //设置监听方法
    String listenerSetter();

    //事件类型
    Class listenerType();

    //事件回调
    String callBackMethod();
}
