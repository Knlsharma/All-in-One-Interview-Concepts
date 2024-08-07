package DP;

/**
 * @author : Kunal Sharma
 * @since : 04/01/23, Wednesday
 **/
public class CountNumberOfWaysToPlaysHouse {

    int MOD = 1000000007;
    public int countHousePlacements(int n) {
        long zero = 1;
        long one = 1;

        for(int i = 2; i <= n; i++){
            long nz = one;
            long no = (zero + one) % MOD;

            one = no;
            zero = nz;
        }

        long tot = (one + zero) % MOD;
        long ans = (tot * tot) % MOD;
        return (int)ans;
    }

    public static void main(String[] args) {

    }
}
