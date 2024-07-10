package LC20240710;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    /**
     * 输入：s = "a good   example"
     * 输出："example good a"
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int length = split.length - 1; length >= 0; length--) {
            result.append(" ").append(split[length]);
        }
        return result.substring(1, result.length());

    }


    @Test
    @DisplayName("反转字符串中的单词")
    public void testLengthOfLongestSubstring(){
        assertAll(
                () -> assertEquals("blue is sky the", reverseWords("the sky is blue")),
                () -> assertEquals("world hello", reverseWords("  hello world  ")),
                () -> assertEquals("example good a", reverseWords("a good   example"))
        );
    }
}
