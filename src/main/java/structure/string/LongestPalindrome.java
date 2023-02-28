package structure.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end   = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇偶回文串
            int lenOdd = expandCenter(s,i,i);
            int lenEven = expandCenter(s,i,i+1);
            int len = Math.max(lenOdd,lenEven);
            if(len > (end-start)){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandCenter(String s,int left,int right){
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    @Test
    @DisplayName("最长回文串")
    public void testSort(){
        assertAll("最长回文串",
                () -> assertEquals("bab",longestPalindrome("babad")),
                () -> assertEquals("bb",longestPalindrome("cbbd"))
        );
    }
}
