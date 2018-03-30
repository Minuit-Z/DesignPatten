package tests;

/**
 * Created by Administrator on 2017/12/4 0004.
 */

public class Utils {

   public void setCallback(Callback callback){
        callback.call("aaa");
   }

    public interface Callback{
        void call(String result);
    }
}
