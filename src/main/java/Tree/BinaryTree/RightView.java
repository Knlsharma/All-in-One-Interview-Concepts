package Tree.BinaryTree;

import java.util.LinkedList;

/**
 * @author Kunal Sharma
 * @created 19/05/2022-12:37 AM
 */
public class RightView {

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

    public static void levelOrderLinewiseSingleQue(TreeNode node) {

        LinkedList<TreeNode> que = new LinkedList<>();

        que.addLast(node);
        while (que.size() != 0) {

            int currSize = que.size();


            for(int i = 0 ; i < currSize ; i++) {

                TreeNode treeNode = que.removeFirst();

                if(i == currSize-1)
                {
                    System.out.println("lastNode is " + treeNode.data);
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
    }
}
