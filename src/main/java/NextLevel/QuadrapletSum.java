package NextLevel;

import java.util.Arrays;

/**
 * @author Kunal Sharma at 10/04/22 5:52 PM
 */
public class QuadrapletSum {

    // TC : O(N^3)

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        Arrays.sort(arr);
        int target = 0;
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int left = j + 1;
                int right = arr.length - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right]);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
    }
}
