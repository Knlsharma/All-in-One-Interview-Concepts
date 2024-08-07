package Tree.BinaryTree.Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 22/07/24, Monday
 **/
public class LevelOrder {

    List<Integer> res = new ArrayList<>();

    // bfs
    public List<Integer> rightSideViewViaBFS(TreeNode root) {

        Queue<TreeNode> que = new ArrayDeque<>();

        if (root != null) {
            que.add(root);
        }

        while (que.size() > 0) {
            int current_size = que.size();
            TreeNode current = null;
            while (current_size-- > 0) {
                current = que.poll();
                if (current != null) {
                    if (current.left != null) {
                        que.add(current.left);
                    }
                    if (current.right != null) {
                        que.add(current.right);
                    }
                }
            }
            res.add(current.val); // add only right
        }
        return res;
    }

    // dfs
    public List<Integer> rightSideViewViaDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        preorder(root, result, 1); // Start DFS traversal from the root at level 1
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result, int level) {
        if (node == null) {
            return;
        }

        // If the current level is equal to the size of result, add the current node value
        if (result.size() < level) {
            result.add(node.val);
        }

        // Traverse right subtree first to get the rightmost node for each level
        preorder(node.right, result, level + 1);
        preorder(node.left, result, level + 1);
    }
}
