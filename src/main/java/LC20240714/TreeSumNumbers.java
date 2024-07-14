package LC20240714;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class TreeSumNumbers {

    public int sumNumbers(TreeNode root) {

        // 求出树的深度 然后 第一层 *10n + 10（n-1)
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int preSum) {
        // 求出树的深度 然后 第一层 *10n + 10（n-1)
        if(root == null){
            return 0;
        }
        int sum = preSum * 10 + root.val;

        if(root.left == null && root.right == null){
            return sum;
        }

        // 每一级都是平的
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    @Test
    @DisplayName("求根到叶子节点数字之和")
    public void testSumNumbers(){
        assertAll(
                () -> assertEquals(25, sumNumbers(TreeNode.constructTree(new Integer[]{1, 2, 3}))),
                () -> assertEquals(1026, sumNumbers(TreeNode.constructTree(new Integer[]{4,9,0,5,1})))
        );
    }
}
