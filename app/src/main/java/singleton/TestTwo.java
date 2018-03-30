package singleton;

/**
 * Created by Administrator on 2017/10/26 0026.
 * 饿汉式
 */

public class TestTwo {
    private static TestTwo instance=new TestTwo();

    private TestTwo(){

    }

    public static TestTwo getInstanceHunger(){
        return instance;
    }
}
