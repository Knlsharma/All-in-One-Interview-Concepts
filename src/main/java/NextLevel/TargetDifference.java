package NextLevel;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 15/08/22, Monday
 **/
public class TargetDifference {

    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        Arrays.sort(arr);

        int j = 0;
        int i = 1;

        while(i < arr.length){
            if(arr[i] - arr[j] > n){
                j++;
                if(j == i){
                    i++;
                }
            } else if(arr[i] - arr[j] < n){
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
