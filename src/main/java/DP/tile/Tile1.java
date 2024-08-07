package DP.tile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : Kunal Sharma
 * @since : 27/03/23, Monday
 **/
public class Tile1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = 1;
            } else if(i == 2){
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        System.out.println(dp[n]);
    }
}
