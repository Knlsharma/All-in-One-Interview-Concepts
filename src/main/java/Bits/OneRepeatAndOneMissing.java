package Bits;

/**
 * @author : Kunal Sharma
 * @since : 30/10/22, Sunday
 **/
public class OneRepeatAndOneMissing {


    public static void solution(int[] arr){
        //write your code here
        int ans = 0;
        for(int val: arr){
            ans = ans ^ val;
        }

        for(int i = 1; i <= arr.length; i++){
            ans = ans ^ i;
        }

        int rsb = ans & -ans;
        int x = 0;
        int y = 0;
        for(int val: arr){
            if((rsb & val) == 0){
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        for(int i = 1; i <= arr.length; i++){
            if((rsb & i) == 0){
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        for(int val: arr){
            if(val == x){
                System.out.println("Missing Number -> " + y);
                System.out.println("Repeating Number -> " + x);
                break;
            } else if(val == y) {
                System.out.println("Missing Number -> " + x);
                System.out.println("Repeating Number -> " + y);
                break;
            }
        }
    }
}
