package LC20240728;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInArray {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;

        while(left <= right){
            if(nums[left] > target && nums[right] < target) {
                return -1;
            }

            if(nums[left] < target){
                left++;
            } else if(nums[left] == target) {
                return left;
            }

            if(nums[right] > target){
                right--;
            }else if(nums[right] == target) {
                return right;
            }
        }

        return -1;
    }

    @Test
    @DisplayName("搜索旋转排序数组")
    public void testThreeSum(){
        assertAll(
                () -> assertEquals(4, search(new int[]{4,5,6,7,0,1,2}, 0)),
                () -> assertEquals(-1, search(new int[]{4,5,6,7,0,1,2}, 3)),
                () -> assertEquals(-1, search(new int[]{1}, 0)),
                () -> assertEquals(0, search(new int[]{1}, 1))
        );
    }

}
