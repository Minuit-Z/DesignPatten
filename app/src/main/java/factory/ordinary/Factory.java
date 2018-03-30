package factory.ordinary;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public abstract class Factory {
    public abstract Product createProduct();

    public abstract <T extends Product> T createNewProdct(Class<T> clazz);
}
