package HashMap;

import java.util.HashSet;

/**
 * @author : Kunal Sharma
 * @since : 22/05/23, Monday
 **/
public class ISAP {
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int val: arr){
            set.add(val);

            if(val < min){
                smin = min;
                min = val;
            } else if(val < smin){
                smin = val;
            }
        }

        int d = smin - min;
        for(int i = 1; i <= n; i++){
            if(set.contains(min) == false){
                return false;
            } else {
                min += d;
            }
        }

        return true;
    }
}
