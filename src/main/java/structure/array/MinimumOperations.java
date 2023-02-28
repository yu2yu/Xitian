package structure.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumOperations {

    public int minimumOperations(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }


    @Test
    @DisplayName("使数组中所有元素都等于零")
    public void test(){
        assertEquals(0,minimumOperations(new int[]{0}));
        assertEquals(3,minimumOperations(new int[]{1,5,0,3,5}));
    }
}
