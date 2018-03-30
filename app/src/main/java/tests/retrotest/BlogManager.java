package tests.retrotest;

import android.content.Context;

import rx.Observable;


/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class BlogManager {
    private BlogService service;
    private Context context;

    public Observable login(int id){
        return service.login(id);
    }

}
