package factory;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public enum Weekday {
    Mon(1),
    Tus(2),
    Wed(3),
    Thu(4),
    Fri(5),
    Sat(6),
    Sun(7);

    private int value;

    private Weekday(int value){
        this.value = value;
    }
}
