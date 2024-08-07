package Bits;

import java.util.Scanner;

/**
 * @author : Kunal Sharma
 * @since : 18/12/22, Sunday
 **/
public class KernigharAlogirthm {

    // jumped to one only
    // used in fenwick tree

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int count = 0;
        while( n != 0)
        {
            int rsbm = n & -n;

            n = n - rsbm;
            count++;
        }

        System.out.println(count);

        //write your code here
    }

}
