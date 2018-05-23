package mvpframe.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import mvpframe.adapter.GirlAdapter;
import mvpframe.base.BaseActivity;
import mvpframe.bean.Girl;
import mvpframe.presenter.GirlsPresenter;
import ziye.text.R;

public class GirlActivity extends BaseActivity<IGirlView, GirlsPresenter<IGirlView>> implements IGirlView {

    private ListView lv;
    private GirlsPresenter girlsPresenter;

    @Override
    public void showLoading() {
        Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<Girl> list) {
        lv.setAdapter(new GirlAdapter(list, this));
    }


    @Override
    protected GirlsPresenter<IGirlView> createPresenter() {
        return new GirlsPresenter<>(this);
    }

    @Override
    protected void increate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_girl);
        lv = (ListView) findViewById(R.id.lv);
        mPresenter.fetch();
    }

}
