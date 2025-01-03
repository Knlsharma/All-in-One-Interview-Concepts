package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 28/03/23, Tuesday
 **/
public class MaximumDifferenceLeftSmallerAndRightJustSmaller {

    int findMaxDiff(int a[], int n)
    {
        // Your code here
        int[] left = nextSmallerToLeft(a);
        int[] right = nextSmallerToRight(a);

        int max = 0;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, Math.abs(left[i] - right[i]));
        }
        return max;
    }

    static int[] nextSmallerToRight(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 &&  arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }

   static  int[] nextSmallerToLeft(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}

