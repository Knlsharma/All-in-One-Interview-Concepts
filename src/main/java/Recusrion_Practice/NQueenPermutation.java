package Recusrion_Practice;

/**
 * @author : Kunal Sharma
 * @since : 03/12/22, Saturday
 **/
import java.io.*;
import java.util.*;

public class NQueenPermutation {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        for(int i = row, j = col; i >= 0; i--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; i < chess.length; i++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; j >= 0; j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; j < chess.length; j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i = row, j = col; i < chess.length && j >= 0; i++, j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if(qpsf == tq){
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess.length; j++){
                    if(chess[i][j] == 0){
                        System.out.print("-\t");
                    } else {
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < tq * tq; i++){
            int row = i / tq;
            int col = i % tq;

            if(chess[row][col] == 0 && IsQueenSafe(chess, row, col) == true){
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}