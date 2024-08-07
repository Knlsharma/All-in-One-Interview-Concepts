package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 28/03/23, Tuesday
 **/
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else if (ch == ')') {
                if(st.size() == 0){       // stack empty still closing found
                    return false;
                } else if(st.peek() != '('){    // mismatch found
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == '}'){
                if(st.size() == 0){
                    return false;
                } else if(st.peek() != '{'){
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == ']'){
                if(st.size() == 0){    // stack empty still closing found
                    return false;
                } else if(st.peek() != '['){      // mismatch found
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return st.size() == 0; // still prsenet in stack means extra
    }
}
