package factory.tests;

/**
 * Created by Administrator on 2017/11/2 0002.
 * 卷轴工厂,可以阅读忍术
 */

public abstract class WaterScrolls {
    public abstract <T extends Ninjutsu> T readMethod(Class<T> clazz) throws ClassNotFoundException;
}
