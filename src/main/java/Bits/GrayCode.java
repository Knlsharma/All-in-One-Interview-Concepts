package Bits;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 30/10/22, Sunday
 **/
public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();

        res.add(0);
        res.add(1);
        for(int i = 2; i <= n; i++){
            int sz = res.size();

            for(int k = sz - 1; k >= 0; k--){
                int val = res.get(k);
                val = val | (1 << (i - 1));
                res.add(val);
            }
        }

        return res;
    }
}
// 00 , 01, 11, 10