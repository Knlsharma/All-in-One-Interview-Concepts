package Tree.BinaryTree.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 08/08/24, Thursday
 **/
public class FindDuplicateSubTree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();
        serializeAndFindDuplicates(root, subtreeMap, result);
        return result;
    }

    // Helper method for DFS traversal and subtree serialization
    private String serializeAndFindDuplicates(TreeNode node, Map<String, Integer> subtreeMap, List<TreeNode> result) {
        if (node == null) return "#";

        // Serialize the subtree
        String serialization = node.val + "," + serializeAndFindDuplicates(node.left, subtreeMap, result) + "," + serializeAndFindDuplicates(node.right, subtreeMap, result);

        // Update map and check for duplicates
        int count = subtreeMap.getOrDefault(serialization, 0);
        if (count == 1) {  // We add the node only if it has been seen exactly once before
            result.add(node);
        }
        subtreeMap.put(serialization, count + 1);

        return serialization;
    }
}
