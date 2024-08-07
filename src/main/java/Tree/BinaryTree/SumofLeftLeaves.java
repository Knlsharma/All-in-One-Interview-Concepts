package Tree.BinaryTree;

/*
 *  @author : Kunal Sharma
 * @since : 14/04/24, Sunday
 */
public class SumofLeftLeaves {

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

    class Solution {
        public int solve(TreeNode curr, boolean isLeft) {
            if (curr == null) {
                return 0;
            }

            if (isLeafNode(curr, isLeft)) {
                return curr.val;
            }

            return solve(curr.left, true) + solve(curr.right, false);
        }

        private boolean isLeafNode(TreeNode curr, boolean isLeft) {
            return curr.left == null && curr.right == null && isLeft;
        }

        public int sumOfLeftLeaves(TreeNode root) {
            return solve(root, false);
        }



        public int sumLeftLeave2(TreeNode curr, TreeNode parent) {
            if (curr == null)
                return 0;

            int left = sumLeftLeave2(curr.left, curr);
            int right = sumLeftLeave2(curr.right, curr);

            int sum = 0;
            if (curr.left == null && curr.right == null) {
                // standing at leaf check if parent sent to leaf
                if (parent != null && parent.left == curr)
                    sum += curr.val;
            }

            return left + right + sum;
        }

        public int sumOfLeftLeaves2(TreeNode root) {
            if (root == null)
                return 0;
            TreeNode parent = null;
            return sumLeftLeave2(root, parent);
        }

    }
}
