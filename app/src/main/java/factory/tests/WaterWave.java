package factory.tests;

import android.util.Log;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class WaterWave extends Ninjutsu{
    @Override
    public void read() {
        Log.e("水遁: 水乱波: ", "辰－丑－卯");
    }

    @Override
    public void ready() {
        Log.e( "ready: ","" );
    }

    @Override
    public void go() {
        Log.e("go: ","喷水" );
    }
}
