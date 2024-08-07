package Stack;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 06/04/24, Saturday
 **/
public class MinimumRemovetoMakeValidParentheses {

    /***************************************************************************** C++ **********************************************************************/
//Approach-1 (Using Stack and set)
//T.C : O(n)
//S.C : O(n)
        public String minRemoveToMakeValid1(String s) {
            int n = s.length();

            HashSet<Integer> toRemove = new HashSet<>();
            Stack<Integer> st = new Stack<>();

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == '(')
                    st.push(i);
                else if(ch == ')') {
                    if(st.isEmpty())
                        toRemove.add(i);
                    else
                        st.pop();
                }
            }

            while(!st.isEmpty())
                toRemove.add(st.pop());

            StringBuilder result = new StringBuilder();

            for(int i = 0; i < n; i++) {
                if(!toRemove.contains(i))
                    result.append(s.charAt(i));
            }

            return result.toString();
        }


    //Approach-2 (Iterate from front and eliminate and then iterate from back and eliminate)
//T.C : O(n)
//S.C : O(n)
        public String minRemoveToMakeValid2(String s) {
            StringBuilder result = new StringBuilder();
            int n = s.length();

            int lastOpen = 0;
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(Character.isLetter(c))
                    result.append(c);
                else if(c == '(') {
                    result.append(c);
                    lastOpen++;
                } else if(lastOpen > 0) {
                    lastOpen--;
                    result.append(c);
                }
            }

            if(result.length() == 0)
                return "";

            s = result.toString();
            result = new StringBuilder();
            int lastClose = 0;
            n = s.length();
            for(int i = n - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if(Character.isLetter(c))
                    result.insert(0, c);
                else if(c == ')') {
                    result.insert(0, c);
                    lastClose++;
                } else if(lastClose > 0) {
                    lastClose--;
                    result.insert(0, c);
                }
            }
            return result.toString();
        }
}
