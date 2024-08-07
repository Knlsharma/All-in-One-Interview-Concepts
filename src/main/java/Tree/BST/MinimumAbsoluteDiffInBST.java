package Tree.BST;

/**
 * @author : Kunal Sharma
 * @since : 20/07/24, Saturday
 **/
public class MinimumAbsoluteDiffInBST {

    int minDiff = Integer.MAX_VALUE;
    // Variable to store the previously visited node during inorder traversal
    TreeNode prev = null;

    // Inorder traversal to find minimum absolute difference
    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        // Traverse left subtree
        inOrder(root.left);

        // Check difference with previous node
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        // Update previous node to current node
        prev = root;

        // Traverse right subtree
        inOrder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        // Initialize previous node as null and perform inorder traversal
        prev = null;
        inOrder(root);

        // Return the minimum difference found
        return minDiff;
    }
}
