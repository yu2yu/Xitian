package structure.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序
        if (nums[0] > 0) return null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i+1,right = nums.length-1;
            while (left<right){
                if((nums[left] + nums[right]) < target){
                    left++;
                }else if((nums[left] + nums[right]) > target){
                    right--;
                }else{
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[left++],nums[right--]));
                    result.add(list);
                    while(left<right && nums[left] == nums[right]) left++;
                    while(left<right && nums[left] == nums[right]) right--;
                }
            }

        }
        return result;
    }


    @Test
    @DisplayName("三数之和")
    public void test(){
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists.toString());
    }
}
