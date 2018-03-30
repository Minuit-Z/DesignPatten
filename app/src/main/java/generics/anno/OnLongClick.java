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
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnLongClickListener",listenerType = View.OnLongClickListener.class,callBackMethod = "onLongClick")
public @interface OnLongClick {
    int[] value() default -1;
}
