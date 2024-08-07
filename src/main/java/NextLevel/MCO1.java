package NextLevel;

import java.util.Arrays;

/**
 * @author Kunal Sharma at 16/04/22 9:26 PM
 */
public class MCO1 {
    // MAXIMUM CONSECUTIVE ONE'S

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0}));
    }

    public static int solution(int[] arr) {

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

                if (zc <= 1) {        // till calculate max len
                    int tlen = i - j;
                    len = Math.max(len, tlen);
                    i++;
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, j+1,i)));
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
                if (zc <= 1) {
                    break;
                }
            }
        }
        return len;

    }


}


