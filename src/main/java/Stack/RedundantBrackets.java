package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 02/04/23, Sunday
 **/
public class RedundantBrackets {
    public int braces(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if("(+-*/".indexOf(ch) != -1){
                st.push(ch);
            } else if(ch == ')') {
                if(st.peek() == '('){
                    return 1;
                } else {
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }

        return 0;
    }
}
