package structure.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class Array {

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
    @Test
    public void findUnsortedSubarray(){

        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        assertEquals(5,findUnsortedSubarrayOne(nums));
        int [] nums2 = {1,2,3,4};
        assertEquals(0,findUnsortedSubarrayOne(nums2));
        int [] nums3 = {1};
        assertEquals(0,findUnsortedSubarrayOne(nums3));

    }

    public int findUnsortedSubarrayOne(int[] nums){
        // 查询是否已经排好序
        boolean flag = true;
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
        while(left < nums.length && nums[left] == copyArray[left]){
            left++;
        }
        int right = nums.length;
        while(right > left && nums[right-1] == copyArray[right-1]){
            right--;
        }
        return right - left;
    }
}
