package LC20240715.LC20240714;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public int maxDepthBreadth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size > 0){
                // 每一层弹出
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }

            ans++;
        }

        return ans;
    }

    @Test
    @DisplayName("二叉树的最大深度")
    public void testSumNumbers(){
        assertAll(
                () -> assertEquals(3, maxDepth(TreeNode.constructTree(new Integer[]{3,9,20,null,null,15,7}))),
                () -> assertEquals(2, maxDepth(TreeNode.constructTree(new Integer[]{1,null,2})))
        );

        assertAll(
                () -> assertEquals(3, maxDepthBreadth(TreeNode.constructTree(new Integer[]{3,9,20,null,null,15,7}))),
                () -> assertEquals(2, maxDepthBreadth(TreeNode.constructTree(new Integer[]{1,null,2})))
        );
    }
}
