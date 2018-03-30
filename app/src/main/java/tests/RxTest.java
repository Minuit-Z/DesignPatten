package tests;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class RxTest {

    private void test() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });


    }
}
