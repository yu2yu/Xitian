package tree;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

    void bfs(TreeNode root){

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            list.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

    }
}
