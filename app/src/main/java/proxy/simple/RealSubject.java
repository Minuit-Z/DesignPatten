package proxy.simple;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class RealSubject implements Subject {
    @Override
    public void visit() {
        Log.e(TAG, "visit: ");
    }
}
