package structure.stack;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class BracketsValid {


    private final Map<Character,Character> map =
            new HashMap<Character,Character>(){{
        put('(',')');
        put('[',']');
        put('{','}');
    }};


    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> brackets = new Stack<>();
        for (char c : chars) {
            if(brackets.isEmpty()){
                brackets.push(c);
            }else {
                Character character = brackets.peek();
                if (null != map.get(character)
                        && c == map.get(character)) {
                    brackets.pop();
                }else{
                    brackets.push(c);
                }
            }
        }
        return brackets.isEmpty();
    }

    @Test
    public void testIsValid(){
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("([)]"));
        assertTrue(isValid("{[]}"));
        assertFalse(isValid("){"));
        assertFalse(isValid("({[)"));
    }

}
