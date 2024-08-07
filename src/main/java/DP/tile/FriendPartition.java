package DP.tile;

/**
 * @author : Kunal Sharma
 * @since : 27/03/23, Monday
 **/
public class FriendPartition {
    int MOD = 1000000007;
    public long countFriendsPairings(int n)
    {
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        //code here
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            long val = ((i - 1) * dp[i - 2]) % MOD;
            dp[i] = (dp[i - 1] + val) % MOD;
        }

        return dp[n];
    }
}
