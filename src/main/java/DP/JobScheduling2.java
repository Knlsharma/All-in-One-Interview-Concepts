package DP;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 01/01/23, Sunday
 **/
public class JobScheduling2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (b1, b2) -> {
            if(b1[0] != b2[0]){
                return b1[0] - b2[0];
            } else {
                return b1[1] - b2[1];
            }
        });

        int[] lis = new int[arr.length];
        lis[0] = arr[0][2];

        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j][1] <= arr[i][0]){
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + arr[i][2];
        }

        int len = 0;
        for(int val: lis){
            len = Math.max(len, val);
        }

        return len;
    }
}
