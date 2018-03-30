package util.rx;

public class MyThrowable extends Throwable {

    private String status;
    //...各种错误信息

    public MyThrowable(String mStatus, String message) {
        super(message);
        this.status = mStatus;
    }


}
