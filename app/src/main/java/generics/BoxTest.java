package generics;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/21 0021.
 */

public class BoxTest {

    public void test(){

        Box<? super Number> box=new Box<>();

        box.setData(new Integer(1));

    }
}
