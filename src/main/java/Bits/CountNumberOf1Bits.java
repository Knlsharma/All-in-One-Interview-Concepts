package Bits;

/**
 * @author : Kunal Sharma
 * @since : 30/10/22, Sunday
 **/

public class CountNumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // kernegal aglorithm
        int count = 0;
        while(n != 0)
        {
            int rsb = n & -n;
            n = n - rsb;
            count++;
        }

        return count;

    }
}