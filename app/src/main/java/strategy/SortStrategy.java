package strategy;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 * 策略模式接口
 */

public interface SortStrategy {
    List<Integer> sort(List<Integer> lists);
}
