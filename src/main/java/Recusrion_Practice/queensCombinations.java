package Recusrion_Practice;

/**
 * @author : Kunal Sharma
 * @since : 03/12/22, Saturday
 **/
import java.io.*;
import java.util.*;

public class queensCombinations {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if(qpsf == tq){
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess.length; j++){
                    if(chess[i][j] == true){
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

//        for specific box index --> row * no.Of col + col

        for(int i = lcno + 1; i < tq * tq; i++){
            int row = i / tq; // getting a row
            int col = i % tq; // getting a column
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i);
            chess[row][col] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}