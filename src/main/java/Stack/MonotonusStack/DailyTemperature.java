package Stack.MonotonusStack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 28/03/23, Tuesday
 **/
public class DailyTemperature {
    public int[] dailyTemperaturesOneWay(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < temp.length; i++){
            while(st.size() > 0 && temp[st.peek()] < temp[i]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        return ans;
    }


    public int[] dailyTemperaturesSecondWay(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        st.push(temp.length - 1);

        for(int i = temp.length - 2; i >= 0; i--){
            while(st.size() > 0 && temp[st.peek()] <= temp[i]){
                st.pop();
            }

            if(st.size() > 0){
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }

}
