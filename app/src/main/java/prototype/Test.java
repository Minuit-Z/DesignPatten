package prototype;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class Test {
    private void test() throws CloneNotSupportedException {

        ArrayList<Integer> lists=new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        User user=new User();
        user.setAge("23");
        user.setName("Minuit");
        user.setScores(lists);

        User user2=user.clone();
    }
}
