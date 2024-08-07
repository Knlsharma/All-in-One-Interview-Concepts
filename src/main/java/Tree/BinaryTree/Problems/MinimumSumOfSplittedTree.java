package Tree.BinaryTree.Problems;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class MinimumSumOfSplittedTree {

    // O(N + N)
    private static final long M = 1_000_000_007L;
    private long totalSum = 0;
    private long maxP = 0;

    public int maxProduct(TreeNode root) {
        if (root == null) return 0;

        totalSum = findTotalSumOfTree(root);
        findTotalSumOfTree(root); // Second pass to calculate max product
        return (int) (maxP % M);
    }

    private long findTotalSumOfTree(TreeNode root) {
        if (root == null) return 0;

        long leftSubtreeSum = findTotalSumOfTree(root.left);
        long rightSubtreeSum = findTotalSumOfTree(root.right);
        long sum = root.val + leftSubtreeSum + rightSubtreeSum;

        maxP = Math.max(maxP, (totalSum - sum) * sum);

        return sum;
    }
}
