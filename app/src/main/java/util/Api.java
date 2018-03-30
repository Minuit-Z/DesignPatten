//package util;
//
//import com.xk.rxdemo.rx.MyThrowable;
//import com.xk.rxdemo.rx.RxSchedulerHelper;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//
///**
// * Created by xuekai on 2018/1/9.
// */
//
//public class Api {
//
//    public static Observable<User> getUser() {
//        return Observable.create(new ObservableOnSubscribe<User>() {
//            @Override
//            public void subscribe(ObservableEmitter<User> e) throws Exception {
//
//                //网络操作
//                User user = new User();
//
//                boolean hasError = false;
//                if (hasError) {
//                    e.onError(new MyThrowable("1","错误信息"));
//                }else{
//                    e.onNext(user);
//                    e.onComplete();
//                }
//
//
//            }
//        }).compose(RxSchedulerHelper.<User>io_main());
//    }
//
//}
