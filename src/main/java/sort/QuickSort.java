package sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yy
 * @version 1.0.0
 * @Description TODO 快速排序
 * @createTime 2022-07-27 15:53:00
 */
public class QuickSort {

    public int[] sort(int[] nums,int low,int high){
        int base = nums[low];
        int left = low,right = high;
        while(left < right){
            while(left < right && nums[right] > base){
                right--;
            }
            if(left < right){
                nums[left++] = nums[right];
            }
            while(left < right && nums[left] < base){
                left++;
            }
            if(left < right){
                nums[right--] = nums[left];
            }
        }
        sort(nums,low,left-1);
        sort(nums,left+1,high);
        return nums;
    }

    @Test
    @DisplayName("快排序")
    public void testQuickSort(){

    }

}
