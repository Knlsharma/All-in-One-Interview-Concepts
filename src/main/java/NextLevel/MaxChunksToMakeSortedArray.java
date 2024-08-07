package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 31/07/22, Sunday
 **/
public class MaxChunksToMakeSortedArray {

    public int maxChunksToSortedBasedOnIndexWay(int[] arr) {
        if(arr.length == 0){
            return 0;
        }

        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i){
                count++;
            }
        }

        return count;
    }

    public int maxChunksAlternativeGenereic(int[] arr) {
        int[] minfr = new int[arr.length];

        minfr[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            minfr[i] = Math.min(arr[i], minfr[i + 1]);
        }

        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            max = Math.max(max, arr[i]);
            if(max <= minfr[i + 1]){
                res++;
            }
        }


        return res + 1;
    }
}
