package mvpframe.view;

import java.util.List;

import mvpframe.bean.Girl;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

//UI的业务逻辑
public interface IGirlView {

    void showLoading(); //加载框

    void showList(List<Girl> list); //回调,显示加载数据
}
