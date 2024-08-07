package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Kunal Sharma
 * @created 23/05/2022-6:16 PM
 */
public class BottomView {


    static  class Pair {
        int horiz = 0;
        Node node;

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

    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> resultList = new ArrayList<>();

        Map<Integer, Node> map = new HashMap<>();

        int leftVar = 0;
        int rightVar = 0;

        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair();
        p.node = root;
        p.horiz = 0 ;

        q.add(p);

        while (q.size() > 0)
        {
            Pair temp = q.remove();

            if(temp.horiz < leftVar)
            {
                leftVar = temp.horiz;
            }

            if(temp.horiz > rightVar)
            {
                rightVar = temp.horiz;
            }

                map.put(temp.horiz, temp.node);

            if(temp.node.left != null)
            {
                Pair lp = new Pair();
                lp.node = temp.node.left;
                lp.horiz = temp.horiz - 1;
                q.add(lp);
            }

            if(temp.node.right != null)
            {
                Pair rp = new Pair();
                rp.node = temp.node.right;
                rp.horiz = temp.horiz + 1;
                q.add(rp);
            }

        }
        for(int i = leftVar ; i <=  rightVar ; i++)
        {
            resultList.add(map.get(i).val);
        }
        return resultList;
    }

}

