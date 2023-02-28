package sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 插入排序
 */
public class InsertionSort {

    public void sort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int left = i;
            while (left > 0 && nums[left] < nums[left - 1]) {
                CommonUtil.swap(left,left-1,nums);
                left--;
            }
        }
    }

    @Test
    @DisplayName("插入排序")
    public void testSort(){
        int[] nums = CommonUtil.generateArray(7, 10);
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
