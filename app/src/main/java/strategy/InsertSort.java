package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 * <p>
 * 插入排序 由大到小
 */

public class InsertSort implements SortStrategy {

    @Override
    public List<Integer> sort(List<Integer> lists) {
        Integer[] data = lists.toArray(new Integer[]{});
        int i, j;
        int num = data.length;
        int target;
        for (i = 1; i < num; i++) {
            target = data[i];
            //j用来记录即将要交换的位置
            for (j = i; j > 0 && target > data[j - 1]; j--) {
                //以此次判断当前的与目标的比较并插入
                //大于时插入 , 为从大到小
                data[j] = data[j - 1];
            }
            data[j] = target;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(data));
        return list;
    }
}
