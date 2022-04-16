package structure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class RecieveRain {


    /**
     * 按照每一层过去接水
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int sum = 0;

        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        // 求出左右两边最大高度
        for (int i = 1; i < height.length-1; i++) {
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for (int i = 1; i < height.length-1; i++) {
            int min = Math.min(max_left[i - 1], max_right[i + 1]);
            if(height[i] < min){
                sum += min - height[i];
            }
        }
        return sum;
    }

    @Test
    public void testTrap(){

        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {4,2,0,3,2,5};

        assertAll(
                () -> assertEquals(6,trap(arr1)),
                () -> assertEquals(9,trap(arr2))
        );

    }

}
