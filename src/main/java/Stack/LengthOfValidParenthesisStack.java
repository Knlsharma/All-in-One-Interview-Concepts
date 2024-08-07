package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 02/04/23, Sunday
 **/
public class LengthOfValidParenthesisStack {

    public int minAddToMakeValid(String s) {

        Stack<Character> stak = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stak.push(ch);
            } else if (stak.size() == 0) {
                stak.push(ch);
            } else if (stak.peek() == ')') {
                stak.push(ch);
            } else {
                stak.pop();
            }
        }

        return stak.size();
    }
}
