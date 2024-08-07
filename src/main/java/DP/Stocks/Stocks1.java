package DP.Stocks;

/**
 * @author : Kunal Sharma
 * @since : 22/01/23, Sunday
 **/
public class Stocks1 {

    public int maxProfit(int[] prices) {

        int bp = prices[0];
        int prof = 0;

        for(int i = 1; i < prices.length; i++){
            bp = Math.min(bp, prices[i]);
            int pist = prices[i] - bp;
            prof = Math.max(prof, pist);
        }

        return prof;

    }
}
