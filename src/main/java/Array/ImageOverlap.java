package Array;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class ImageOverlap {
    public int countOverLaps(int[][] A, int[][] B, int rowOff, int colOff) {

        int n = A.length;

        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                //find indices of B from A ka indices [i][j]


                int B_i = i + rowOff;

                int B_j = j + colOff;


                if (B_i < 0 || B_i >= n || B_j < 0 || B_j >= n)
                    continue;

                if (A[i][j] == 1 && B[B_i][B_j] == 1) {
                    count++;

                }

            }


        }

        return count;

    }

    public int largestOverlap(int[][] A, int[][] B) {


        int n = A.length; // 2

        int maxOverLap = 0;
        for (int rowOff = -n + 1; rowOff < n; rowOff++) { // -1 to 1

            for (int colOff = -n + 1; colOff < n; colOff++) { // -1 to 1

                int count = countOverLaps(A, B, rowOff, colOff);

                maxOverLap = Math.max(maxOverLap, count);

            }

        }

        return maxOverLap;
    }

}
