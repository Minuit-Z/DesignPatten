package mvpframe.model;


import android.support.annotation.UiThread;

import java.util.List;

import mvpframe.bean.Girl;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
public interface IGirlModle {
    void loadGirl(onLoadListener listener);


    interface onLoadListener {

        @UiThread
        void onCompile(List<Girl> list); //加载完毕的回调
    }
}
