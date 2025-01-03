package Bits;

/**
 * @author : Kunal Sharma
 * @since : 22/08/24, Thursday
 **/

//Approach-1 (Using bit magic of XOR)
//T.C : O(log2(num))
//S.C : O(1)
public class FindCompliment {

    public int findComplement1(int num) {
        int numberOfBits = (int) (Math.log(num) / Math.log(2)) + 1;

        for (int i = 0; i < numberOfBits; i++) {
            num = num ^ (1 << i); // Take XOR to flip
        }
        return num;
    }

    // Approach-2 (Using XOR mask)
    // T.C : O(log2(num))
    // S.C : O(1)
    public int findComplement2(int num) {
        if (num == 0)
            return 1;

        // Calculate the number of bits in num
        int number_of_bits = (int) (Math.log(num) / Math.log(2)) + 1;

        // Create a mask with all bits set to 1 that are of the same length as num
        int mask = (1 << number_of_bits) - 1;

        // XOR num with mask to get the complement
        return num ^ mask;
    }


    // Approach-3 (Iterate digit by digit and create complement)
    // T.C : O(log2(num))
    // S.C : O(1)
    public int findComplement3(int num) {
        int i = 0, ans = 0;
        while (num != 0) {
            // If the current bit is 0, set the corresponding bit in ans to 1
            if ((num & 1) == 0)
                ans |= (1 << i);
            num >>= 1;
            i++;
        }
        return ans;
    }
}
