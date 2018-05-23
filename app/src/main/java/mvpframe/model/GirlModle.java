package mvpframe.model;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import mvpframe.bean.Girl;
import ziye.text.R;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class GirlModle implements IGirlModle {

    Handler handler;
    @Override
    public void loadGirl(final onLoadListener listener) {

        handler=new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        //模拟请求数据
                        List<Girl> list = new ArrayList<>();

                        list.add(new Girl(R.mipmap.ic_launcher, "1"));
                        list.add(new Girl(R.mipmap.ic_launcher, "2"));
                        list.add(new Girl(R.mipmap.ic_launcher, "3"));
                        list.add(new Girl(R.mipmap.ic_launcher, "4"));
                        list.add(new Girl(R.mipmap.ic_launcher, "5"));
                        list.add(new Girl(R.mipmap.ic_launcher, "6"));
                        list.add(new Girl(R.mipmap.ic_launcher, "7"));

                        //回调
                        listener.onCompile(list);
                    }
                });
            }
        }).start();
    }
}
