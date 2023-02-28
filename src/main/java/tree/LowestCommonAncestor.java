package tree;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        // 如果p，q都在左子树
        if(find(root.left, p) && find(root.left, q)){
            return lowestCommonAncestor(root.left,p,q);
        }

        // 如果p，q都在右子树
        if(find(root.right, p) && find(root.right, q)){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }

    private boolean find(TreeNode root, TreeNode node){
        if (root == null) return false;
        if (root.val == node.val) {
            return true;
        }
        return find(root.left, node) || find(root.right, node);

    }

}
