package sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 */
public class BubbleSort {


    /**
     * 最简单的就是两两交换位置
     * @param nums
     * @return
     */
    public int[] sort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j+1]){
                    swap(j,j+1,nums);
                }
            }
            System.out.println("第"+ (i+1) + "轮排序，结果为：");
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    /**
     * 如果后面没有交换数据就不用比了，因为已经排好序了
     * @param nums
     * @return
     */
    public int[] sortOptimization(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j+1]){
                    swap(j,j+1,nums);
                    swapFlag = true;
                }
            }
            System.out.println("第"+ (i+1) + "轮排序，结果为：");
            System.out.println(Arrays.toString(nums));
            if(!swapFlag) break;
        }
        return nums;
    }


    public void swap(int i,int j,int[] nums){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    @Test
    @DisplayName("冒泡排序")
    public void testSort(){
        sort(new int[]{1,5,2,7,9,2,4,5});
    }
}
