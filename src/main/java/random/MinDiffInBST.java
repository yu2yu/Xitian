package random;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description 二叉搜索树节点最小距离
 *  给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *  差值是一个正数，其数值等于两值之差的绝对值。
 * @createTime 2022-06-08 09:01:00
 */
public class MinDiffInBST {
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    // 查找出最大最小值
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = null;
        dfs(root);
        return min;
    }


    // 中序遍历
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        // 逻辑
        if(pre == null){
            pre = root;
        }else{
            min = Math.min(min,root.val - pre.val);
            pre = root;
        }
        dfs(root.right);
    }

    @Test
    public void testMinDiffInBST(){
        TreeNode root = TreeNode.constructTree(new Integer[]{4,2,6,1,3});
        assertEquals(1,minDiffInBST(root));

        TreeNode root2 = TreeNode.constructTree(new Integer[]{1,0,48,null,null,12,49});
        assertEquals(1,minDiffInBST(root2));
    }
}
