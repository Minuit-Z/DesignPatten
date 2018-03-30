//package util.rx;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableSource;
//import io.reactivex.ObservableTransformer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.schedulers.Schedulers;
//
//
///**
// * 切换线程工具
// */
//public class RxSchedulerHelper {
//
//    public static <T> ObservableTransformer<T, T> io_main() {
//
//        return new ObservableTransformer<T, T>() {
//
//            @Override
//            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
//                return upstream.subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread());
//            }
//        };
//    }
//    public static <T> ObservableTransformer<T, T> io_io() {
//
//        return new ObservableTransformer<T, T>() {
//
//            @Override
//            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
//                return upstream.subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
//                        .observeOn(Schedulers.io());
//            }
//        };
//    }
//}
