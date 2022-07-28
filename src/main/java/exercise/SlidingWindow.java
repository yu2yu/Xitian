package exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description TODO 滑动窗口
 * @createTime 2022-07-25 10:54:00
 */
public class SlidingWindow {


    public int lengthOfLongSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    @Test
    @DisplayName("最大子字符串")
    public void testLengthOfLongSubstring(){
        assertAll("最大子字符串",
                () -> assertEquals(3,lengthOfLongSubstring("abcabcbb")),
                () -> assertEquals(1,lengthOfLongSubstring("bbbbb")),
                () -> assertEquals(1,lengthOfLongSubstring(" ")),
                () -> assertEquals(0,lengthOfLongSubstring("")),
                () -> assertEquals(3,lengthOfLongSubstring("pwwkew"))
        );
    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr]
     * 并返回其长度。如果不存在符合条件的子数组，返回 0
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int start = 0,end = 0,sum = 0;
        int min = Integer.MAX_VALUE;
        while(end < n){
            sum += nums[end];
            while(sum >= target){
                min = Math.min(min,end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    @Test
    @DisplayName("最大子数组")
    public void testMinSubArrayLen(){
        assertAll("最大子数组",
                () -> assertEquals(2,minSubArrayLen(7,new int[]{2,3,1,2,4,3})),
                () -> assertEquals(1,minSubArrayLen(4,new int[]{1,4,4})),
                () -> assertEquals(0,minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}))
        );
    }


    public int longestOnes(int k,int[] nums){
        int max = Integer.MIN_VALUE;
        int left = 0,end = 0,zero = 0;
        while(end < nums.length){
            if(nums[end] == 0){
                zero++;
            }
            while(zero>k){
                if(nums[left++] == 0){
                    zero--;
                }
            }
            max = Math.max(max,end-left+1);
            end++;
        }
        return max == Integer.MIN_VALUE?0:max;
    }

    @Test
    @DisplayName("最大连续1的个数")
    public void testLongestOnes(){
        assertAll("最大连续1的个数",
                () -> assertEquals(6,longestOnes(2,new int[]{1,1,1,0,0,0,1,1,1,1,0})),
                () -> assertEquals(10,longestOnes(3,new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}))
        );
    }

}