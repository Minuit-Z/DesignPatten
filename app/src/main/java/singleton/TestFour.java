package singleton;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class TestFour {
    private TestFour(){}
    public static TestFour getInstance(){
        return SingletonHolder.instance;
    }

    // 内部类
    private static class SingletonHolder{
        private static final TestFour instance=new TestFour();
    }
}
