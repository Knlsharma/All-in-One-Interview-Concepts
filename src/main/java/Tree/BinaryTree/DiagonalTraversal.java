package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma
 * @created 27/05/2022-12:33 PM
 */

public class DiagonalTraversal {
  static class TreeNode {

      TreeNode leftNode;
      TreeNode rightNode;
      int data;
  }

   public static  ArrayList<Integer> diagonalTraversal(TreeNode root)
   {
       Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        goAndTraverse(root, 0 , map);

        ArrayList<Integer> total = new ArrayList<>();

        for(int d = 0 ; d <= max_diag ; d++)
        {
            ArrayList<Integer> integers = map.get(d);
            if(integers == null)
            {
                continue;
            }
            for(Integer item  : integers)
            {
                total.add(item);
            }

        }

       return total;
   }

    static int max_diag = 0;
    private static void goAndTraverse(TreeNode root, int diag, Map<Integer, ArrayList<Integer>> map) {
      if(root == null)
      {
          return;
      }

      if(diag > max_diag)
      {
          max_diag = diag;
      }

       if(!map.containsKey(diag))
       {
           map.put(diag ,  new ArrayList<>());
           map.get(diag).add(root.data);
       }
       else
       {
           map.get(diag).add(root.data);
       }

      goAndTraverse(root, diag+1,map);
      goAndTraverse(root, diag,map);

    }

    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    }
}
