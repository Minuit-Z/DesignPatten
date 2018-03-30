//package util.rx;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//
//import io.reactivex.disposables.CompositeDisposable;
//
//public abstract class BaseActivity extends AppCompatActivity {
//    public CompositeDisposable disposables = new CompositeDisposable();
//
//
//    /**
//     * 全局的dialog
//     */
//    private MyDialog dialog=new MyDialog();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    private LoadingView loading = new LoadingView();
//
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        disposables.clear();
//        hideLoadingView();
//    }
//
//
//
//    public void hideLoadingView() {
//        loading.hide();
//    }
//    public void showLoadingView() {
//        loading.show();
//    }
//
//    public void showDialog(MyThrowable myThrowable) {
//        dialog.showDialog(myThrowable);
//    }
//
//
//
//}
