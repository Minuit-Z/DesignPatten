package factory.tests;

import android.util.Log;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class WaterShark extends Ninjutsu{
    @Override
    public void read() {
        Log.e("水遁 水鲛弹术: ","寅—丑—辰—卯—酉—辰—未 " );
    }

    @Override
    public void ready() {
        Log.e( "ready: ","寅—丑—辰—卯—酉—辰—未" );
    }

    @Override
    public void go() {
        Log.e("go: ","水鲛弹" );
    }
}
