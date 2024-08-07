package Recusrion_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : Kunal Sharma
 * @since : 02/12/22, Friday
 **/
public class Combination {
    // nCr where r is identical  items as we are doing only Selection

    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
        // write your code here


        if(cb > tb)
        {
            if(ssf == ts)
            {
                System.out.println(asf);
            }
            return;
        }

        combinations(cb+1, tb, ssf +1, ts, asf+"i");      // Yes
        combinations(cb+1, tb, ssf, ts, asf+"-");         // No
        // here boxes are level and items are

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }
}
