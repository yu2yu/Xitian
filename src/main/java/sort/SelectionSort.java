package sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description 选择排序
 */
public class SelectionSort {

    public int[] selectionSort(int[] nums){
        for (int j = 0; j < nums.length - 1;j++) {
            int min = j;
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
            CommonUtil.swap(min, j, nums);
        }
        return nums;
    }


    @Test
    @DisplayName("选择排序")
    public void testSort(){
        int[] nums = CommonUtil.generateArray(7, 10);
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
