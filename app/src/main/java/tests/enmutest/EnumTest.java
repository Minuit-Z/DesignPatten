package tests.enmutest;

import android.util.Log;

import tests.enmutest.enumEntity.Kind;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/2/26 0026.
 */

public class EnumTest {


    public void test() {
        testOne(Kind.格斗家);
    }

    protected void testOne(Kind kind) {
        Log.e(TAG, "testOne: " + kind);
    }

    protected void testTwo(Kind kind){
        switch (kind){
            case 圣职者:
            case 格斗家:
            case 鬼剑士:
        }
    }

}
