package singleton;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class TestThree {
    private volatile static TestThree instance=null;

    private TestThree(){
    }

    public static TestThree getInstance(){
        if (instance==null){
            synchronized (TestThree.class){
                if (instance==null){
                    instance=new TestThree();
                }
            }
        }
        return instance;
    }
}
