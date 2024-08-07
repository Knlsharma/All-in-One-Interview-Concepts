package NextLevel;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 14/08/22, Sunday
 **/
public class MinPlatform {

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int max = 0;

        int i = 0;
        int j = 0;
        while(i < arr.length && j < dep.length){
            int arrival  =  arr[i];
            int departure = dep[j];
            if(arrival <= departure){
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            max = Math.max(count, max);
        }

        return max;

    }
}
