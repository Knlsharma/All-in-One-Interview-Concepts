package NextLevel;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kunal Sharma at 26/03/22 2:45 PM
 */
public class CheckInAP {
    public static void main(String[] args) {

        int[] arr = new int[] {0, 12, 4, 8};
//        static int n = arr.length - 1;

        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int val : arr)
        {
            set.add(val);

            if(min > val) {
                smin = min;
                min = val;
            }
            else if(smin > min)
            {
                smin = val;
            }
        }

        System.out.println(isAPprogression(min, smin, set));


    }

    private static boolean isAPprogression(int min, int smin, Set<Integer> set) {
        int diff = min - smin;

        for(int i = 1 ; i <= 4 ; i++)
        {
            int term = min + (i - 1) * diff;
            if(!set.contains(term))
            {
                return false;
            }
            else
            {
               // do nothing
            }

        }
        return true;
    }


}
