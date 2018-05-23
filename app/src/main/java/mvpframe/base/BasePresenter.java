package mvpframe.base;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/4/9 0009.
 * <p>
 * T 对应着activity,即View层的抽象接口
 */

public abstract class BasePresenter<T> {

    //持有View层的弱引用
    protected WeakReference<T> mViewRef;

    /**
     * 获取数据的方法
     */
    public abstract void fetch();

    //绑定
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    //解绑
    public void dettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
