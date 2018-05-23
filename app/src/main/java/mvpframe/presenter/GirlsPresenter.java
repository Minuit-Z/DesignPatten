package mvpframe.presenter;

import java.util.List;

import mvpframe.base.BasePresenter;
import mvpframe.view.IGirlView;
import mvpframe.bean.Girl;
import mvpframe.model.GirlModle;
import mvpframe.model.IGirlModle;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class GirlsPresenter<T extends IGirlView> extends BasePresenter<IGirlView>{

    //此时的P层持有视图层的引用 ,为Activity
    IGirlView mView;
    //持有模型层的引用
    IGirlModle mModle = new GirlModle();

    public GirlsPresenter(IGirlView mView) {
        this.mView = mView;
    }

    //开始耗时操作
    @Override
    public void fetch() {
        mView.showLoading();
        if (null != mModle)
            //获取数据并进行回调
            mModle.loadGirl(new IGirlModle.onLoadListener() {
                @Override
                public void onCompile(List<Girl> list) {
                    //将数据给视图层
                    mView.showList(list);
                }
            });
    }

}
