package Tree.BinaryTree;

import Tree.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 08/08/24, Thursday
 **/
public class IsSameTree {

    // approach 1
    // T.C :- O(N) , S.C :- O(1)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One of the nodes is null, the other is not
        if (p == null || q == null) {
            return false;
        }

        // The values of the current nodes are different
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // approach 2
    // T.C :- O(N) , S.C :- O(N)
    public boolean isSameTreeViaBFS(Tree.BinaryTree.TreeNode p, Tree.BinaryTree.TreeNode q) {
        // Use queues to perform level-order traversal
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Tree.BinaryTree.TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Tree.BinaryTree.TreeNode first = queue1.poll();
            Tree.BinaryTree.TreeNode second = queue2.poll();

            // Both nodes are null, continue to next iteration
            if (first == null && second == null) {
                continue;
            }

            // One of the nodes is null, or values differ
            if (first == null || second == null || first.val != second.val) {
                return false;
            }

            // Enqueue left children
            if (first.left != null && second.left != null) {
                queue1.add(first.left);
                queue2.add(second.left);
            } else if (first.left != null || second.left != null) {
                return false;
            }

            // Enqueue right children
            if (first.right != null && second.right != null) {
                queue1.add(first.right);
                queue2.add(second.right);
            } else if (first.right != null || second.right != null) {
                return false;
            }
        }

        // Check if both queues are empty
        return queue1.isEmpty() && queue2.isEmpty();
    }
}