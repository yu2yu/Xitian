package structure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 41. 缺失的第一个正数
 * @Description <p>给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案</p>
 *
 * @Example 输入：nums = [1,2,0]
 * 输出：3
 *
 */
public class FindMissingPositive {


    @Test
    public void findMissingPositive(){
        int[] nums = {1,2,0};
        int [] nums2 = {3,4,-1,1};
        int [] nums3 = {7,8,9,11,12};
        assertEquals(3,firstMissingPositive(nums));
        assertEquals(2,firstMissingPositive(nums2));
        assertEquals(1,firstMissingPositive(nums3));

    }


    /**
     * 思路： 最小的正整数 给定一个数组 不管是什么数 取值范围肯定在 [1,N] N是数组长度
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] <= 0){
                nums[i] = length+1;
            }
        }

        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if(num < length+1){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }

        for (int i = 0; i < length; i++) {
            if(nums[i] > 0){
                return i+1;
            }
        }
        return length+1;
    }


    @Test
    public void findMissingPositiveTwo(){
        int[] nums = {1,2,0};
        int [] nums2 = {3,4,-1,1};
        int [] nums3 = {7,8,9,11,12};
        assertEquals(3,firstMissingPositiveTwo(nums));
        assertEquals(2,firstMissingPositiveTwo(nums2));
        assertEquals(1,firstMissingPositiveTwo(nums3));
    }

    /**
     * 思路：通过置换原数组，如果该位置不等于i+1
     * @param nums
     * @return
     */
    public int firstMissingPositiveTwo(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            while(nums[i] > 0 && nums[i] < length+1 && nums[i] != nums[nums[i]-1]){
                temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return length+1;
    }

}
