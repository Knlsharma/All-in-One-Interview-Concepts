package Bits;

import java.util.Scanner;

/**
 * @author : Kunal Sharma
 * @since : 18/12/22, Sunday
 **/
public class RSB {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int twoCompliment = (~n + 1);

        System.out.print(Integer.toBinaryString(n & twoCompliment));

        //write your code here
    }

}
