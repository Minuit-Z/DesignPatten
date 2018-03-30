package strategy;


import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 *
 * 策略环境
 */

public class SortListUtil<T extends SortStrategy> {
    SortStrategy sort;

    public void setSortStrategy(T sort){
        this.sort=sort;
    }

    public List<Integer> sortData(List<Integer> lists){
        return sort.sort(lists);
    }
}
