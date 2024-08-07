package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Kunal Sharma
 * @created 18/05/2022-11:00 PM
 */
public class ReverseLevelOrderTraversalLinewise {

    static  class  temp
    {
        int data;
        LevelOrder.temp left;
        LevelOrder.temp right;

        temp(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }


    public static void levelOrderLinewise(LevelOrder.temp root)
    {
        Queue<LevelOrder.temp> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Stack<String> stak = new Stack<>();

        String res = null;

        while(q.size() > 0)
        {
            LevelOrder.temp temp = q.remove();

            if(temp != null) {
                res += temp.data + " ";

                // System.out.print(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            else
            {
                stak.add(res  + "\n");
                res = "";
                if(q.size() > 0)
                {
               //     System.out.println();
                    q.add(temp);
                }

            }

            while(stak.size() > 0)
            {
                System.out.println(stak.pop());
            }

        }
    }
}
