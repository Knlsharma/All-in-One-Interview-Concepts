package Tree.BinaryTree;

/**
 * @author : Kunal Sharma
 * @since : 10/07/22, Sunday
 **/



class InorderSuccessor
{

}
//class Solution
//{
//    // returns the inorder successor of the Node x in BST (rooted at 'root')
//    public Node inorderSuccessor(Node root,Node x) {
//        Node curr = root;
//        Node prev = null;
//        Node succ = null;
//
//        while(curr != null){
//            if(curr.left == null){
//                if(prev == x){
//                    return curr;
//                }
//                prev = curr;
//
//                curr = curr.right;
//            } else {
//                Node iop = curr.left;
//                while(iop.right != null && iop.right != curr){
//                    iop = iop.right;
//                }
//
//                if(iop.right == null){
//                    iop.right = curr; // making the thread
//                    curr = curr.left;
//                } else {
//                    // print
//
//                    if(prev == x){
//                        return curr;
//                    }
//                    prev = curr;
//                    iop.right = null;
//                    curr = curr.right;
//                }
//            }
//
//
//        }
//        return succ;
//    }