package ziye.text;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import generics.anno.ConvertView;
import generics.anno.OnClick;
import generics.anno.ViewInject;


@ConvertView(R.layout.activity_second)
public class SecondActivity extends BaseActivity {

    @ViewInject(R.id.btn_1)
    protected Button btn;

    @Override
    public void increate(Bundle savedInstanceState) {
        btn.setText("BBBBBB");
    }

    @OnClick(R.id.btn_1)
    public void click1(View view) {
        Toast.makeText(this, "btn1", Toast.LENGTH_SHORT).show();
    }
}
