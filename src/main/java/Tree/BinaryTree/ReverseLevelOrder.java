package Tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Kunal Sharma
 * @created 18/05/2022-11:18 PM
 */
public class ReverseLevelOrder {

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


    public static ArrayList<Integer> reverseLevelOrder(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        Stack<Integer> stack = new Stack<>();

        while(q.size() > 0) {
            TreeNode temp = q.remove();

            stack.push(temp.data);

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }

                while(stack.size() > 0)
                {
                    list.add(stack.pop());
                }

        return list;
    }


    public static List<List<Integer>> reverseLevelOrderWithList(TreeNode root)
    {
        List<List<Integer>> big_list= new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Stack<ArrayList<Integer>> stack = new Stack<>();

        ArrayList<Integer> curr_list = null;
        while(q.size() > 0) {
            TreeNode temp = q.remove();
            if(temp != null)
            {
//                curr_list = new ArrayList<>();

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                curr_list.add(temp.data);

            }
            else {
                stack.push(curr_list);
                curr_list = new ArrayList<>();


            }
        }

        while(stack.size() > 0)
        {
            big_list.add(stack.pop());
        }

        return big_list;
    }
}
