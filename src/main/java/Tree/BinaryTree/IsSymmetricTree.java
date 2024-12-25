package Tree.BinaryTree;

/**
 * @author : Kunal Sharma
 * @since : 08/08/24, Thursday
 **/
public class IsSymmetricTree {

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {  // check both are not null
            return true;
        }
        if (t1 == null || t2 == null) {  // check either one of them is null
            return false;
        }

        // Check if current nodes are equal and recursively check the subtrees
        return t1.val == t2.val && check(t1.left, t2.right) && check(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }
}
