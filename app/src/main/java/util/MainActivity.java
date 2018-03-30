//package util;
//
//import android.os.Bundle;
//
//import com.xk.rxdemo.rx.BaseActivity;
//import com.xk.rxdemo.rx.ComposeObserver;
//import com.xk.rxdemo.rx.MyThrowable;
//
//public class MainActivity extends BaseActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        Api.getUser().subscribe(new ComposeObserver<User>(disposables, this, true) {
//            @Override
//            public void onSuccess(User user) {
//                //...
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                super.onError(e);
//                if (e instanceof MyThrowable) {
//                    showDialog((MyThrowable) e);
//                } else {
//                    //其他运行时异常，理论上是不允许出现
//                }
//            }
//        });
//
//
//    }
//}
