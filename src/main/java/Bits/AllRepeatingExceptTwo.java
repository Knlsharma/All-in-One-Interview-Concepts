package Bits;

import java.util.Scanner;

/**
 * @author : Kunal Sharma
 * @since : 30/10/22, Sunday
 **/
public class AllRepeatingExceptTwo {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr){
        //write your code here
        int ans = 0;
        for(int val: arr){
            ans = ans ^ val;
        }

        int rsb = ans & -ans;

        int x = 0;
        int y = 0;
        for(int val: arr){
            if((val & rsb) == 0){
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        if(x > y){   // just for printing
            int temp = x;
            x = y;
            y = temp;
        }

        System.out.println(x);
        System.out.println(y);
    }
}



