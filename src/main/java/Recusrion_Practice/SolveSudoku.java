package Recusrion_Practice;

import java.util.Scanner;

/**
 * @author : Kunal Sharma
 * @since : 03/12/22, Saturday
 **/
public class SolveSudoku {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean IsSafe(int[][] board, int i, int j, int val) {
        for (int jj = 0; jj < board[0].length; jj++) {   // checking vertically
            if (board[i][jj] == val) {
                return false;
            }
        }

        for (int ii = 0; ii < board.length; ii++) {  // checking horizontally
            if (board[ii][j] == val) {
                return false;
            }
        }

        int ii = i / 3 * 3; //  getting points of 1st row for that subMatrix
        int jj = j / 3 * 3; //  getting points of 1st col for that subMatrix
        if (isValuePresentInSubMatrix(board, val, ii, jj)) return false;

        return true;
    }

    private static boolean isValuePresentInSubMatrix(int[][] board, int val, int ii, int jj) {
        for (int ci = 0; ci < 3; ci++) {
            for (int cj = 0; cj < 3; cj++) {
                if (board[ii + ci][jj + cj] == val) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void solveSudoku(int[][] board, int i, int j) {
        // write yopur code here
        if (i == board.length) {
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (IsSafe(board, i, j, val) == true) {
                    board[i][j] = val;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}
