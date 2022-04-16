package structure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParentheses {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int length = 0;
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if('(' == aChar){
                stack.push(aChar);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    length += 2;
                }
            }
        }
        return length;
    }


    @Test
    public void testLongestValidParentheses(){
        assertAll(
                () -> assertEquals(2,longestValidParentheses("(()")),
                () -> assertEquals(4,longestValidParentheses(")()())")),
                () -> assertEquals(4,longestValidParentheses("()(()")),
                () -> assertEquals(0,longestValidParentheses(""))
        );
    }
}
