package generics.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/3/26 0026.
 */
//运行是也存在
@Retention(RetentionPolicy.RUNTIME)
//用在类上的注解
@Target(ElementType.FIELD)
public @interface ViewInject {
    int value();
}
