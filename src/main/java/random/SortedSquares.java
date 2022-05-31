package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-05-31 08:13:00
 */
public class SortedSquares {


    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // 双指针
        int left = 0,right = nums.length - 1,cur = nums.length - 1;
        while (left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[cur] = nums[right] * nums[right];
                right--;
            }else{
                result[cur] = nums[left] * nums[left];
                left++;
            }
            cur--;
        }
        return result;
    }


    @Test
    public void testSortedSquares(){
        assertArrayEquals(new int[]{0,1,9,16,100},sortedSquares(new int[]{-4,-1,0,3,10}));
        assertArrayEquals(new int[]{4,9,9,49,121},sortedSquares(new int[]{-7,-3,2,3,11}));
    }

}
