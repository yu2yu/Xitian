package exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description TODO 滑动窗口
 * @createTime 2022-07-25 10:54:00
 */
public class SlidingWindow {


    /**
     1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
     此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

     2、如果当前字符 ch 包含在 map中，此时有2类情况：
     1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
     那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
     2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
     而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
     随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
     应该不变，left始终为2，子段变成 ba才对。

     为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
     另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
     因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
     */
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