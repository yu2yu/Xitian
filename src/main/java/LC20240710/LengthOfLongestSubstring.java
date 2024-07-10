package LC20240710;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.cn/problems/wtcaE1/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;
        Set<Character> characters = new HashSet<Character>();
        int right = -1;
        for (int i = 0; i < length; i++) {
            if(i != 0){
                characters.remove(s.charAt(i-1));
            }
            // 查找当前字符下的最长子字符串
            while((right+1) < length && !characters.contains(s.charAt(right+1))){
                characters.add(s.charAt(right+1));
                ++right;
            }
            maxLength = Math.max(maxLength, right-i+1);
        }
        return maxLength;
    }


    @Test
    @DisplayName("不含重复字符的最长子字符串")
    public void testLengthOfLongestSubstring(){
        assertAll(
                () -> assertEquals(3, lengthOfLongestSubstring("abcabcbb")),
                () -> assertEquals(1, lengthOfLongestSubstring("bbbbb")),
                () -> assertEquals(3, lengthOfLongestSubstring("pwwkew"))
        );
    }
}
