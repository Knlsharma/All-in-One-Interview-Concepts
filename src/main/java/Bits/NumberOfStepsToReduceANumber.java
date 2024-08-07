package Bits;

/**
 * @author : Kunal Sharma
 * @since : 29/05/24, Wednesday
 **/

// TC : O(n)
// SC : O(1)
public class NumberOfStepsToReduceANumber {

    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Iterate through the string from the end to the second character
        for (int i = s.length() - 1; i >= 1; i--) {
            steps++; // Increment steps for each iteration
            // If the current character plus carry is 1
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1; // Set carry to 1 for the next iteration
                steps++; // Increment steps for the carry operation
            }
        }
        // Add carry to the total steps if there is a leftover carry
        return steps + carry;
    }
}
