package Tree.BinaryTree;

import java.util.*;

/**
 * @author Kunal Sharma
 * @created 23/05/2022-6:20 PM
 */

public class VerticalOrder {

    static  class Pair implements Comparable<Pair> {
        int width;
        TreeNode node;
        int depth;

        Pair(TreeNode node, int width, int depth)
        {
            this.node = node;
            this.depth = depth;
            this.width = width;
        }

        // this means increasing
        // that means decreasing

        @Override
        public int compareTo(Pair other) {
            if(this.depth == other.depth)
            {
                return  this.node.val - other.node.val; // sort on basis of val
            }
            else
            {
                return  this.depth - other.depth;   // sort on depth
            }
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static  List<List<Integer>> verticalTraversal(TreeNode node) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0, 1));

        int left_most_width = 0;
        int right_most_width = 0;

        Map<Integer, ArrayList<Pair>> map = new HashMap<>();

        List<List<Integer>> res = null;
        while (q.size() > 0) {
            Pair curr_pair = q.remove();

            if (curr_pair.width < left_most_width) {
                left_most_width = curr_pair.width;
            }

            if (curr_pair.width > right_most_width) {
                right_most_width = curr_pair.width;
            }

            if (!map.containsKey(curr_pair.width)) {
                map.put(curr_pair.width, new ArrayList<>());
                map.get(curr_pair.width).add(curr_pair);
            } else {
                map.get(curr_pair.width).add(curr_pair);
            }

            if (curr_pair.node.left != null) {
                Pair leftPair = new Pair(curr_pair.node.left, curr_pair.width - 1, curr_pair.depth + 1);
                q.add(leftPair);
            }

            if (curr_pair.node.right != null) {
                Pair rightPair = new Pair(curr_pair.node.right, curr_pair.width + 1, curr_pair.depth + 1);
                q.add(rightPair);
            }

            res = new ArrayList<>();

            for (int i = left_most_width; i <= right_most_width; i++) {

                List<Integer> small_list = new ArrayList<>();

                ArrayList<Pair> unsorted_List = map.get(i);
                Collections.sort(unsorted_List);

                for (Pair pair : unsorted_List) {
                    small_list.add(pair.node.val);
                }

                res.add(small_list);
            }

        }

        return res;
    }

}
