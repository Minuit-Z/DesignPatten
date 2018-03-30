package generics.anno;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

@Retention(RetentionPolicy.RUNTIME)
//用于方法上的注解
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnClickListener",listenerType = View.OnClickListener.class,callBackMethod = "onClick")
public @interface OnClick {

    int[] value() default -1;
}
