package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 02/04/23, Sunday
 **/
public class MinimumNumberOFBracketReversal {

    int countRev (String s)
    {
        if(s.length() % 2 == 1){
            return -1;
        }

        // your code here
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                st.push(ch);
            } else if(st.size() > 0){
                if(st.peek() == '{'){
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);
            }
        }

        int open = 0;
        int close = 0;
        while(st.size() > 0){
            if(st.peek() == '{'){
                open++;
            } else {
                close++;
            }
            st.pop();
        }

        return (open + 1) / 2 + (close + 1) / 2;
    }
}
