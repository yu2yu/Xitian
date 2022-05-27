package random;

import org.junit.jupiter.api.Test;
import structure.link.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 */
public class MinDeletionSize {


    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 1){
            return 0;
        }
        int count = 0;
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            for (int i1 = 0; i1 < strs.length-1; i1++) {
                if(strs[i1 + 1].charAt(i) < strs[i1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void testPairSum(){
        assertEquals(1,minDeletionSize(new String[]{"cba","daf","ghi"}));
        assertEquals(0,minDeletionSize(new String[]{"a","b"}));
        assertEquals(3,minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }

}
