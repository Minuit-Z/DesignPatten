package mvpframe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/4/9 0009.
 * <p>
 * V为抽象UI的接口实现 , T为P层的引用
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        increate(savedInstanceState);
    }

    protected abstract void increate(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        mPresenter.dettach();
        super.onDestroy();
    }

    /**
     * 模板模式
     *
     * @return 创建的具体的Presenter层
     */
    protected abstract T createPresenter();

}
