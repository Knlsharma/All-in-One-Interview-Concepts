package Tree.BinaryTree.Problems;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class MaximumDiffBtwAncestorAndChild {

    //Approach-1 (Brute Force) - O(n^2) - n = number of nodes in the Tree
/*
  Just simply take a root, find all the differences of it from its childrens and find max one
  Again go to root->left and do the same as above
  Again go to root->right and do the same as above
*/
    int maxDiff;

    void findMaxUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        findMaxUtil(root, child.left);
        findMaxUtil(root, child.right);
    }

    void findMaxDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // Find max differences of this root with all its children
        findMaxUtil(root, root.left);
        findMaxUtil(root, root.right);

        // Further move left and right
        findMaxDiff(root.left);
        findMaxDiff(root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = Integer.MIN_VALUE;

        findMaxDiff(root);

        return maxDiff;
    }

//Approach-2
//Optimal (O(n)) using min and max value for |min-max|
    public int findMaxDiffVia2(TreeNode root, int minV, int maxV) {
        if (root == null) {
            return Math.abs(minV - maxV);
        }

        minV = Math.min(root.val, minV);
        maxV = Math.max(root.val, maxV);

        int l = findMaxDiffVia2(root.left, minV, maxV);
        int r = findMaxDiffVia2(root.right, minV, maxV);

        return Math.max(l, r);
    }

    public int maxAncestorDiffVia2(TreeNode root) {
        int minV = root.val;
        int maxV = root.val;

        return findMaxDiffVia2(root, minV, maxV);
    }
}
