package ziye.text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import generics.InjectUtils;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将当前对象注入到第三方的容器
        InjectUtils.inject(this);
        increate(savedInstanceState);
    }

    public abstract void increate(Bundle savedInstanceState);
}
