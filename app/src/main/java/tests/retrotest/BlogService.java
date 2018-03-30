package tests.retrotest;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public interface BlogService {

    @GET("login")
    Observable<Object> login(@Query("132") int id);

}
