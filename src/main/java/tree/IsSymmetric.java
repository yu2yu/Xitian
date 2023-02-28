package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root){

        if(root == null || (root.left == null && root.right == null)) return true;

        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root.left);
        treeNodes.add(root.right);

        while(!treeNodes.isEmpty()){

            TreeNode left = treeNodes.poll();
            TreeNode right = treeNodes.poll();

            // 左右节点对称
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            treeNodes.add(left.left);
            treeNodes.add(right.right);

            treeNodes.add(left.right);
            treeNodes.add(right.left);
        }
        return true;
    }



}
