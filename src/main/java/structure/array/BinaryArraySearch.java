package structure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二分法
 */
public class BinaryArraySearch {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int middle = (left + right)/2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch(){
        int[] nums = {-1,0,3,5,9,12};
        int[] nums2 = {5};
        assertEquals(4,search(nums,9));
        assertEquals(-1,search(nums,2));
        assertEquals(0,search(nums2,5));

    }


    /**
     * 搜索插入位置
     * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        // 左开右闭
        int left = 0,right = nums.length-1,ans = nums.length;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if(nums[middle] < target){
                left = middle+1;
            }else{
                ans = middle;
                right = middle-1;
            }
        }
        return ans;
    }

    @Test
    public void testSearchInsert(){
        int[] nums = {1,3,5,6};
        int[] nums2 = {1};
        assertEquals(2,searchInsert(nums,5));
        assertEquals(1,searchInsert(nums,2));
        assertEquals(4,searchInsert(nums,7));
        assertEquals(0,searchInsert(nums,0));
        assertEquals(0,searchInsert(nums2,0));

    }


    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     * 找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int leftBound = findIndex(nums,target,true);
        int rightBound = findIndex(nums,target,false) - 1;

        if(leftBound <= rightBound && rightBound < nums.length
                && nums[leftBound] == target && nums[rightBound] == target){
            return new int[]{leftBound,rightBound};
        }
        return new int[]{-1,-1};
    }

    private int findIndex(int[] nums, int target,boolean lower) {
        int left = 0,right = nums.length-1,ans = nums.length;
        while(left <= right){
            int middle = (left + right)>>1;
            // lower && nums[middle] >= target 继续往左边寻找
            if(nums[middle] > target  || (lower && nums[middle] >= target)){
                ans = middle;
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return ans;
    }


    @Test
    public void testRange(){
        int[] nums = {5,7,7,8,8,10};
        int[] nums2 = {};
        assertArrayEquals(new int[]{3,4},searchRange(nums,8));
        assertArrayEquals(new int[]{-1,-1},searchRange(nums,6));
        assertArrayEquals(new int[]{-1,-1},searchRange(nums2,0));
    }


    public int mySqrt(int x) {
        int left = 0,right = x,ans = -1;
        while(left <= right){
            int middle = (left + right) >> 1;
            if(middle*middle <= x){
                ans = middle;
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return ans;
    }


    public int mySqrt2(int x) {
        if(x == 0){
            return 0;
        }
        double c = x,x0 = x;
        while(true){
            double xi = 0.5 * (x0 + c/x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    @Test
    public void testSqrt(){
        assertEquals(2,mySqrt(4));
        assertEquals(2,mySqrt(8));
        assertEquals(1,mySqrt(1));
        assertEquals(0,mySqrt(0));

        assertEquals(2,mySqrt2(4));
        assertEquals(2,mySqrt2(8));
        assertEquals(1,mySqrt2(1));
        assertEquals(0,mySqrt2(0));
    }
}
