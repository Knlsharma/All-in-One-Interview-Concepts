package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


// 1.) NUll , 2.) count wale jisme 2 inner loops , 3.) Pair approach

/**
 * @author kunal sharma
 */
public class LevelOrder {

     static  class  temp
     {
         int data;
         temp left;
         temp right;

         temp(int data)
         {
             this.data = data;
             this.left = null;
             this.right = null;
         }

     }

    static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class LOPair
    {
        int level;
        Node node;

        LOPair(Node node, int level)
        {
            this.level = level;
            this.node = node;
        }
    }


    public static void levelOrderLinewise(temp root)
    {
        Queue<temp> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size() > 0)
        {
            temp temp = q.remove();

            if(temp != null) {
                System.out.print(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            else
            {
                if(q.size() > 0)
                {
                    System.out.println();
                    q.add(temp);
                }

            }

        }
    }

    public static void levelOrderLinewisePair(Node root)
    {

        Queue<LOPair> q = new LinkedList<>();

        q.add(new LOPair(root, 1));
        int cl = 1;

        // Algo => Remove, print , add

        while (q.size() > 0)
        {
            LOPair currPair = q.remove();

            if(currPair.level > cl)
            {
                System.out.println();
                currPair.level =  cl;
            }

            System.out.print(currPair.node.val + " ");

            if(currPair.node.right != null)
            {
                LOPair rightPair = new LOPair(currPair.node.right, currPair.level + 1);
                q.add(rightPair);
            }

            if(currPair.node.left != null)
            {
                LOPair leftPair = new LOPair(currPair.node.left, currPair.level + 1);
                q.add(leftPair);
            }
        }
    }
}
