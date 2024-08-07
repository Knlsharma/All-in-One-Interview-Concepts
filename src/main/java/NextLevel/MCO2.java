package NextLevel;

import java.util.Arrays;

/**
 * @author Kunal Sharma at 16/04/22 11:49 PM
 */


public class MCO2 {
    // MAXIMUM CONSECUTIVE ONE'S

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0}, 3));
    }

    public static int solution(int[] arr, int k) {

        int len = 0;
        int i = 0;
        int j = -1;
        int zc = 0;  // zero counts

        while (i < arr.length && j < i) {

            // acquire strategy
            while (i < arr.length) {
                if (arr[i] == 1) {
                    // nothing to do
                } else if (arr[i] == 0) {
                    zc++;
                }

                if (zc <= k) {        // till calculate max len
                    int tlen = i - j;
                    len = Math.max(len, tlen);
                    i++;
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, j + 1, i)));
                } else {
                    i++;
                    break;
                }
            }

            // release strategy
            while (j < i) {
                j++;
                if (arr[j] == 0) {
                    zc--;
                }
                if (zc <= k) {
                    break;
                }
            }
        }
        return len;

    }


}



