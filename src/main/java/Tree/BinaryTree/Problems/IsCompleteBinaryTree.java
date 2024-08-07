package Tree.BinaryTree.Problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 22/07/24, Monday
 **/
public class IsCompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean past = false; // Have we encountered a null node before?

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) { // 1st Null encounter
                past = true;
            } else {
                // If we have encountered a null node before, and we encounter a non-null node now, it's not a complete tree
                if (past) {
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }


    /******************* DFS ******************/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean dfs(TreeNode root, int i, int totalNodes) {
        if (root == null) {
            return true;
        }

        if (i > totalNodes) {
            return false;
        }

        return dfs(root.left, 2 * i, totalNodes) &&
                dfs(root.right, 2 * i + 1, totalNodes);
    }

    public boolean isCompleteTreeViaDFS(TreeNode root) {
        int totalNodes = countNodes(root);

        int i = 1;
        return dfs(root, i, totalNodes);
    }
}
