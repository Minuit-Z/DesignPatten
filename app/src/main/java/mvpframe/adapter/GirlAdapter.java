package mvpframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mvpframe.bean.Girl;
import ziye.text.R;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class GirlAdapter extends BaseAdapter {
    private List<Girl> girls;
    private Context context;

    public GirlAdapter(List<Girl> girls, Context context) {
        this.girls = girls;
        this.context=context;
    }

    @Override
    public int getCount() {
        return girls.size();
    }

    @Override
    public Object getItem(int position) {
        return girls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        TextView tv;

        View v= LayoutInflater.from(context).inflate(R.layout.item_girl,null);

        img= (ImageView) v.findViewById(R.id.img);
        tv= (TextView) v.findViewById(R.id.tv);

        img.setImageDrawable(context.getDrawable(girls.get(position).imgId));
        tv.setText(girls.get(position).desc);

        return v;
    }
}
