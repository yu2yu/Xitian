package LC20240715.LC20240714;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.cn/problems/xx4gT2/description/
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            if(i < k) priorityQueue.offer(nums[i]);
            else if(i>=k && nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.poll();
    }


    public int findKthLargestQuickSelect(int[] nums, int k) {
        return 0;
    }

    @Test
    @DisplayName("数组中第k大元素")
    public void testThreeSum(){
        assertAll(
                () -> assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2)),
                () -> assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4))
        );
    }

}
