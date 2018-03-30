package generics;

/**
 * Created by Administrator on 2018/3/21 0021.
 */

public class Box<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
