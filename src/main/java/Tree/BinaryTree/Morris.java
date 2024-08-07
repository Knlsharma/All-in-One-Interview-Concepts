package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 10/07/22, Sunday
 **/
public class Morris {

    // Morris is only for In-order, and Pre-order

  public class TreeNode {
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

    public List<Integer> inorderTraversalUsingMorris(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                retVal.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }

                if(iop.right == null){
                    iop.right = curr; // making the thread
                    curr = curr.left;
                } else {
                    iop.right = null;
                    retVal.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return retVal;
    }

    public List<Integer> preorderTraversalUsingMorris(TreeNode root) {


        List<Integer> retVal = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){    // if left is absent
                retVal.add(curr.val);
                curr = curr.right;    // move right
            } else {
                TreeNode iop = curr.left;    // storing iop
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;   // explore inorder predecessor
                }

                if(iop.right == null){    // if iop right is null
                    retVal.add(curr.val);  // print it
                    iop.right = curr; // making the thread
                    curr = curr.left;  // moving towards left
                } else {
                    iop.right = null;    // break the thread
                    curr = curr.right;   // move towards right
                }
            }
        }

        return retVal;

    }
}
