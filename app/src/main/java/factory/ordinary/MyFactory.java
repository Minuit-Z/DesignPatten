package factory.ordinary;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class MyFactory extends Factory{
    @Override
    public Product createProduct() {
        return new MyProductA();
    }

    /**
    *@author 张子扬
    *@time 2017/11/2 0002 11:16
    *@desc 使用反射扩展兼容性
    */
    @Override
    public <T extends Product> T createNewProdct(Class<T> clazz) {
        Product p=null;
        try {
            p= (Product) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)p;
    }
}
