package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 16/07/22, Saturday
 **/
public class SmallestGreatestInteger {
    public static void main(String[] args) {

    }
    public int nextGreaterElement(int n) {
        char[] arr =  (n + "").toCharArray();

        int end = arr.length - 1;
        while(end > 0)
        {
            if(arr[end-1] >= arr[end])
            {
                end--;
            }
            else {
                break;
            }
        }

        if(end == 0)
        {
            return  -1;
        }
        // no number found above

        int indexm1 = end - 1;
        int new_end = arr.length - 1;

        while(new_end  > indexm1)
        {
            if(arr[new_end] > arr[indexm1])
            {
                break;
            }
            new_end--;
        }

        swap(arr, new_end, indexm1);


        //reverse
        int left = end;
        int right = arr.length - 1;
        while(left < right)
        {
            swap(arr,left, right);
            left++;
            right--;
        }

        //convert your answer
        String res = new String(arr);
        long val = Long.parseLong(res);

        return (val > Integer.MAX_VALUE) ? -1 : (int) val;
    }

    public  static void swap (char[] arr, int si, int ei)
    {
        char temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;

    }
}
