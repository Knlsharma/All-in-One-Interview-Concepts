package Tree.BinaryTree;


/**
 * @author : Kunal Sharma
 * @since : 22/07/24, Monday
 **/

public class LCA {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftNodeFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNodeFound = lowestCommonAncestor(root.right, p, q);

        if (leftNodeFound != null && rightNodeFound != null) {
            return root;
        }

        return (leftNodeFound != null) ? leftNodeFound : rightNodeFound;
    }
}
