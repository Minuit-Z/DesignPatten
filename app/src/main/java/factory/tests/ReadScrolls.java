package factory.tests;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class ReadScrolls extends WaterScrolls {
    @Override
    public <T extends Ninjutsu> T readMethod(Class<T> clazz) {
        Ninjutsu ni = null;
        try {
            ni = (Ninjutsu) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) ni;
    }
}
