package tests.enmutest.enumEntity;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2018/2/26 0026.
 */

public class Depart {
    public static final int MALE = 0001;
    public static final int FEMALE = 0002;

    //值约束
    @IntDef({MALE, FEMALE})
    //表示注解所存活的时间: 源码,而非运行时
    @Retention(RetentionPolicy.SOURCE)
    //定义注解接口
    public @interface SEX {
    }

    //对sex变量有约束
    @SEX
    private int sex;

    public void setSex(@SEX int sex) {
        this.sex = sex;
    }

    @SEX
    public int getSex() {
        return sex;
    }

    public String getSexDes() {
        if (sex == MALE) {
            return "男";
        } else {
            return "女";
        }
    }

    public void test(){

    }
}
