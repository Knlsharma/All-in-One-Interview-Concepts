package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kunal Sharma
 * @created 19/05/2022-12:18 AM
 */
public class LeftView {

    static  class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static List<Integer> leftView(TreeNode node) {

        if(node == null)
        {
            return new ArrayList<>();
        }
        List<Integer> ls = new ArrayList<>();

        LinkedList<TreeNode> que = new LinkedList<>();

        que.addLast(node);
        while (que.size() != 0) {

            int currSize = que.size();


           for(int i = 0 ; i < currSize ; i++) {

                TreeNode treeNode = que.removeFirst();

                if(i == 0)
                {
                    ls.add(treeNode.data);
                }

                if(treeNode.left != null)
                {
                    que.addLast(treeNode.left);
                }

               if(treeNode.right != null)
               {
                   que.addLast(treeNode.right);
               }

            }

            System.out.println();

        }
        return ls;
    }
}
