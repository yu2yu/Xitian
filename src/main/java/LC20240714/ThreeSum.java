package LC20240714;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            // 相同则跳过
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            if(nums[i] > 0){
                return result;
            }
            int left = i+1, right = length - 1;
            while (left < right) {
                if(left> (i + 1) && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else if(sum == 0){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    @Test
    @DisplayName("三数之和")
    public void testThreeSum(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,0,0}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

}
