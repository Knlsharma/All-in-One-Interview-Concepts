package Bits;

import java.io.*;
import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 30/10/22, Sunday
 **/

public class Bits1 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        //write your code here
        int mask = 0;

        mask = 1 << i;
        System.out.println(mask);
        System.out.println(n | mask);

        mask = ~(1 << j);
        System.out.println(mask);
        System.out.println(n & mask);

        mask = 1 << k;
        System.out.println(mask);
        System.out.println(n ^ mask);

        mask = 1 << m;
        System.out.println(mask);
        int check = n & mask;
        if(check == 0){
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

}
