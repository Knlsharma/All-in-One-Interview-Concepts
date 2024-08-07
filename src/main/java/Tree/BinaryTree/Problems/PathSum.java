package Tree.BinaryTree.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 23/07/24, Tuesday
 **/
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, sum, temp, result);
        return result;
    }

    private void collectPaths(TreeNode root, int curr, List<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;

        temp.add(root.val);

        if (root.left == null && root.right == null && root.val == curr) {
            result.add(new ArrayList<>(temp));
        }

        collectPaths(root.left, curr - root.val, temp, result);
        collectPaths(root.right, curr - root.val, temp, result);

        temp.remove(temp.size() - 1);
    }

    int currentSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return isValidPath(root, currentSum, targetSum);
    }

    private boolean isValidPath(TreeNode root, int currentSum, int targetSum) {

        if (root == null) {
            return false;
        }

        currentSum += root.val;
        System.out.println("updating current sum " + currentSum + " " + "root val + " + root.val);


        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }

        System.out.println("PreOrder :: Sum is so far " + currentSum);
        boolean isLeft = isValidPath(root.left, currentSum, targetSum);
        System.out.println("InOrder :: before :: Sum is so far " + currentSum);

        System.out.println("InOrder :: after :: Sum is so far " + currentSum);
        boolean isRight = isValidPath(root.right, currentSum, targetSum);
        System.out.println("PostOrder :: Sum is so far " + currentSum);

        return isLeft || isRight;
    }
}
