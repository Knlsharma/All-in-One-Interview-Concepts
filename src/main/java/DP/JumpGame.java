package DP;

/**
 * @author Kunal Sharma at 16/04/22 11:43 AM
 */
public class JumpGame {

    static int[] arr;
    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 1, 4};
        arr = ints;

        System.out.println(canJump(0));
    }

    public static boolean canJump(int index) {
     if(index > arr.length)
     {
         return false;
     }
     else if(index == arr.length - 1) return  true;
     else {
         boolean b = canJump(index - 1);
     }



        return false;
    }
}
