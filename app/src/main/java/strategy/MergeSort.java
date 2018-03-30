package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 * <p>
 * 归并排序
 */

public class MergeSort implements SortStrategy {
    @Override
    public List<Integer> sort(List<Integer> lists) {

        Integer[] arr = (Integer[]) lists.toArray();
        int low = 0;
        int high = arr.length - 1;

        List<Integer> data=new ArrayList<>(Arrays.asList(sort(arr, low, high)));
        return data;
    }

    private Integer[] sort(Integer[] arr, int low, int high) {

        int mid = (low + high) / 2;

        if (low < high) {
            // 左边
            sort(arr, low, mid);
            // 右边
            sort(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public void merge(Integer[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
