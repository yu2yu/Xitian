package tree;

import org.junit.platform.commons.util.Preconditions;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){ }


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode constructTree(Integer[] arr){
        if(arr == null || arr.length == 0) throw new NullPointerException();
        TreeNode root = new TreeNode(arr[0]);

        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        int index = 1,length = arr.length;
        while(index < length){
            TreeNode poll = nodeDeque.poll();
            if(arr[index] != null){
                poll.left = new TreeNode(arr[index]);
                nodeDeque.offer(poll.left);
            }
            if(index+1 < length && arr[index+1] != null){
                poll.right = new TreeNode(arr[index+1]);
                nodeDeque.offer(poll.right);
            }
            index += 2;
        }
        return root;
    }

}
