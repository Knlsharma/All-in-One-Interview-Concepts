package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 24/07/24, Wednesday
 **/
public class SortTheJumbledNumbers {

    //T.C : O(n*d + nlogn) , Here, n is the size of the nums vector, and d is the average number of digits in the numbers.
//S.C : O(n)
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> vec = new ArrayList<>(); // O(n)

        for (int i = 0; i < n; i++) { // O(n)
            int mappedNum = getMappedNum(nums[i], mapping); // O(d)
            vec.add(new Pair(mappedNum, i));
        }

        Collections.sort(vec, (a, b) -> Integer.compare(a.mappedNum, b.mappedNum));
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int originalNumIdx = vec.get(i).originalIdx;
            result[i] = nums[originalNumIdx];
        }

        return result;
    }

    private int getMappedNum(int num, int[] mapping) {
        if (num < 10) {
            return mapping[num];
        }

        int mappedNum = 0;
        int placeValue = 1;

        while (num > 0) {
            int lastDigit = num % 10;
            int mappedDigit = mapping[lastDigit];
            mappedNum += placeValue * mappedDigit;

            placeValue *= 10;
            num /= 10;
        }

        return mappedNum;
    }

    private static class Pair {
        int mappedNum;
        int originalIdx;

        Pair(int mappedNum, int originalIdx) {
            this.mappedNum = mappedNum;
            this.originalIdx = originalIdx;
        }
    }
}
