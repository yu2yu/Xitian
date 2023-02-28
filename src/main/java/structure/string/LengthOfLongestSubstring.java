package structure.string;

import org.junit.jupiter.api.Test;
import structure.link.ListNode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0,max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    

}
