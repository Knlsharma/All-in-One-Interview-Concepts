package BinarySearch;

/**
 * @author : Kunal Sharma
 * @since : 28/07/24, Sunday
 **/
public class SearchIn2DMatrix {

    // 1st approach :- O( logn ) [ this one is optimised ]
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] > target) {
                end = mid - 1;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    //2nd approach : O(m + n) : means use this as array ( Also call star case )
    public boolean searchMatrixVi2nd(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] < target) {
                row++; // increase  row
            } else if (matrix[row][col] > target) {
                col--; // decrease col
            } else {
                return true;
            }
        }
        return false;
    }

    // new question type below
    // taking advantage of 2nd sorted property as per question
    public boolean searchMatrixIn2nd(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

}
