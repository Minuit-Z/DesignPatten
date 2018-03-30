package singleton;

/**
 * @author 张子扬
 * @time 2017/10/26 0026 9:26
 * @desc 饱汉式
 */
public class TextOne {
    private static TextOne instance;

    private TextOne(){

    }

    public static synchronized TextOne getInstanceFull(){
        if (instance==null){
            instance=new TextOne();
        }
        return instance;
    }
}
