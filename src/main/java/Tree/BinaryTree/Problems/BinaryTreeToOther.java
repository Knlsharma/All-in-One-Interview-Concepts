package Tree.BinaryTree.Problems;


import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class BinaryTreeToOther {

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

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        // Explore left
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        // Explore right
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDst = new StringBuilder();

        findPath(root, startValue, rootToSrc); // O(n)
        findPath(root, destValue, rootToDst);  // O(n)

        int l = 0; // commonPathLength
        while (l < rootToSrc.length() && l < rootToDst.length() &&
                rootToSrc.charAt(l) == rootToDst.charAt(l)) {
            l++;
        }

        // common break point is at l

        StringBuilder result = new StringBuilder();
        // Add "U" for root to src
        for (int i = 0; i < rootToSrc.length() - l; i++) {
            result.append('U');
        }

        for (int i = l; i < rootToDst.length(); i++) {
            result.append(rootToDst.charAt(i));
        }

        return result.toString();
    }

    /*********** approach 2 *************
     *
     *
     */

    class Pair {
        TreeNode node;
        char direction; // 'L' or 'R'

        Pair(TreeNode node, char direction) {
            this.node = node;
            this.direction = direction;
        }
    }

    public List<Character> findPath(TreeNode root, TreeNode startNode, TreeNode endNode) {
        // Initialize BFS queue and visited set
        Queue<Pair> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        // Map to store parent information
        Map<TreeNode, Pair> parentMap = new HashMap<>();

        // Start BFS from the root
        queue.offer(new Pair(root, '\0')); // '\0' represents no direction at root
        visited.add(root);

        // Perform BFS
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            TreeNode current = currentPair.node;
            char direction = currentPair.direction;

            // If we found startNode or endNode, backtrack to find path
            if (current == startNode || current == endNode) {
                return constructPath(parentMap, startNode, endNode);
            }

            // Explore left child
            if (current.left != null && !visited.contains(current.left)) {
                queue.offer(new Pair(current.left, 'L'));
                visited.add(current.left);
                parentMap.put(current.left, new Pair(current, 'L')); // Record parent and direction
            }

            // Explore right child
            if (current.right != null && !visited.contains(current.right)) {
                queue.offer(new Pair(current.right, 'R'));
                visited.add(current.right);
                parentMap.put(current.right, new Pair(current, 'R')); // Record parent and direction
            }
        }

        // If no path found (ideally should not happen in valid tree structure)
        return new ArrayList<>();
    }

    // Function to backtrack from node1 to node2 to construct path
    private List<Character> constructPath(Map<TreeNode, Pair> parentMap, TreeNode node1, TreeNode node2) {
        List<Character> path = new ArrayList<>();

        // Backtrack from node1 to node2 using parentMap
        TreeNode current = node1;
        while (current != node2) {
            Pair parentPair = parentMap.get(current);
            path.add(parentPair.direction);
            current = parentPair.node;
        }

        // Reverse the path as it was constructed from node1 to node2
        Collections.reverse(path);

        return path;
    }


}
