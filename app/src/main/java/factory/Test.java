package factory;

import factory.ordinary.ClazFactory;
import factory.ordinary.Factory;
import factory.ordinary.MyProductA;
import factory.ordinary.Product;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public class Test {
    Weekday w=Weekday.Fri;

    Factory factory=new ClazFactory();

    public void test(){
        Product newProdct = factory.createNewProdct(MyProductA.class);
        newProdct.method();
    }

}
