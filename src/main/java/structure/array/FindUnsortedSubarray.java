package structure.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 最短无序连续子数组
 * @Description <p>给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 *  如果对这个子数组进行升序排序，那么整个数组都会变为升序排序</p>
 *
 * @Example 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 */
public class FindUnsortedSubarray {


    @Test
    public void findUnsortedSubarray(){

        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int [] nums2 = {1,2,3,4};
        int [] nums3 = {1};
        assertEquals(5,findUnsortedSubarrayOne(nums));
        assertEquals(0,findUnsortedSubarrayOne(nums2));
        assertEquals(0,findUnsortedSubarrayOne(nums3));

        assertEquals(5,findUnsortedSubarrayTwo(nums));
        assertEquals(0,findUnsortedSubarrayTwo(nums2));
        assertEquals(0,findUnsortedSubarrayTwo(nums3));

    }

    /**
     * 思路：也就是找出 三个子数组 A B C
     *  满足 A，C里面所有的元素有序 而且B里面的所有元素大于A小于C并且无序
     *  双指针
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayOne(int[] nums){
        // 查询是否已经排好序
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]){
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        int[] copyArray = new int[nums.length];
        System.arraycopy(nums,0,copyArray,0,nums.length);
        Arrays.sort(copyArray);
        int left = 0;
        while(nums[left] == copyArray[left]){
            left++;
        }
        int right = nums.length;
        while(nums[right-1] == copyArray[right-1]){
            right--;
        }
        return right - left;
    }


    /**
     * 双指针
     * 左右指针什么时候移动？
     * 右指针只需要右边是最大数,因此只要求出左边的最大数即可
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayTwo(int[] nums){

        int n = nums.length;
        int max = Integer.MIN_VALUE,right = -1;
        int min = Integer.MAX_VALUE,left = -1;

        for (int i = 0; i < n; i++) {
            if(max > nums[i]){
                right = i;
            }else{
                max = nums[i];
            }
            if(nums[n-1-i] < min){
                min = nums[n-1-i];
            }else{
                left = n -1-i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
