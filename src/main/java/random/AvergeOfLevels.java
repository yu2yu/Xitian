package random;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *  求出每一层节点的平均值
 */
public class AvergeOfLevels {

    // 层次遍历
    public List<Double> averageOfLevels(TreeNode root){
        ArrayList<Double> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double sum = 0,size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode rootNode = queue.poll();
                sum += rootNode.val;
                if(rootNode.left != null){
                    queue.offer(rootNode.left);
                }
                if(rootNode.right != null){
                    queue.offer(rootNode.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }


    @Test
    public void testAvergeOfLevels(){
        TreeNode root = TreeNode.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<Double> doubles = averageOfLevels(root);
        assertArrayEquals(new Double[]{3.0, 14.5, 11.0},doubles.toArray());

        TreeNode root2 = TreeNode.constructTree(new Integer[]{3, 9, 20,15, 7});
        List<Double> doubles2 = averageOfLevels(root2);
        assertArrayEquals(new Double[]{3.0, 14.5, 11.0},doubles2.toArray());
    }

}
