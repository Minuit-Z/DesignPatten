package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 * <p>
 * 冒泡排序,从大到小
 */

public class BubbleSort implements SortStrategy {
    @Override
    public List<Integer> sort(List<Integer> lists) {
        int i, j;
        int num = lists.size();
        int target;
        Integer[] data = lists.toArray(new Integer[]{});

        //从上到下,依次下沉 , i为比较的位置
        for (i = 0; i < num - 1; i++) {
            for (j = 0; j < num - i; j++) {
                if (data[i] > data[j]) {
                    //大于时交换 , 为下沉操作
                    target = data[i];
                    data[i] = data[j];
                    data[j] = target;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(data));
    }
}
