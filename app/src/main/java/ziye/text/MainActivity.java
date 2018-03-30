package ziye.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wevey.selector.dialog.DialogOnItemClickListener;
import com.wevey.selector.dialog.NormalSelectionDialog;

import java.util.ArrayList;

import tests.Utils;
import tests.enmutest.enumEntity.Depart;
import tests.enmutest.enumEntity.Person;


public class MainActivity extends AppCompatActivity {

    NormalSelectionDialog dialog1;
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);
        iv = (ImageView) findViewById(R.id.img);

        dialog1 = new NormalSelectionDialog.Builder(MainActivity.this)
                .setlTitleVisible(true) //设置是否显示标题
                .setTitleHeight(65) //设置标题高度
                .setTitleText("please select") //设置标题提示文本
                .setTitleTextSize(14) //设置标题字体大小 sp
                .setTitleTextColor(R.color.colorPrimary) //设置标题文本颜色
                .setItemHeight(40) //设置item的高度
                .setItemWidth(0.9f) //屏幕宽度*0.9
                .setItemTextColor(R.color.colorPrimaryDark) //设置item字体颜色
                .setItemTextSize(14) //设置item字体大小
                .setCancleButtonText("Cancle") //设置最底部“取消”按钮文本
                .setOnItemListener(new DialogOnItemClickListener() { //监听item点击事件
                    @Override
                    public void onItemClick(Button button, int position) {
                        dialog1.dismiss();
                        Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                    }
                }).setCanceledOnTouchOutside(true)
                //设置是否可点击其他地方取消
                .build();
        ArrayList<String> s = new ArrayList<>();
        s.add("Weavey0");
        s.add("Weavey1");
        s.add("Weavey2");
        s.add("Weavey3");
        dialog1.setDataList(s);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();
            }
        });

        //Builder模式
//        UserBean build = new UserBean.UserBuilder().age(1)
//                .address("xxx")
//                .firstName("Ziya")
//                .build();


        //策略模式 冒泡排序
//        List<Integer> lists = new ArrayList<>();
//        lists.add(5);
//        lists.add(4);
//        lists.add(7);
//        lists.add(2);
//        SortStrategy strategy = new InsertSort();
//        List<Integer> sort = strategy.sort(lists);
//        for (Integer i : sort) {
//            Log.e("onCreate: ", i + "");
//        }

        Utils u = new Utils();
        u.setCallback(new Utils.Callback() {
            @Override
            public void call(String result) {

            }
        });

//        Log.e("onCreate: ", Person.Br.getName());

//        Log.e("onCreate: ", Depart.MALE+"");
        Depart depart = new Depart();
        depart.setSex(Depart.MALE);
        Log.e("onCreate: ", depart.getSexDes());

        tv.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
