package Tree.BinaryTree;


class ColoringGameTree {

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

    static int xLeft;
    static int xRight;

    public static int size(TreeNode node, int num)
    {
        if(node == null)
        {
            return 0;
        }

        int leftSize = size(node.left , num);
        int rightSize = size(node.right , num);


        if(node.val == num)
        {
            xLeft = leftSize;
            xRight = rightSize;
        }

        return leftSize + rightSize + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        size(root, x);
        int otherSide = n - (xLeft + xRight + 1);

        int maxOfThree = Math.max(otherSide, Math.max(xLeft,xRight));
        int rest = n - maxOfThree;

        if(maxOfThree > rest)
        {
            return true;
        }
        else
        {
            return false;
        }



    }
}