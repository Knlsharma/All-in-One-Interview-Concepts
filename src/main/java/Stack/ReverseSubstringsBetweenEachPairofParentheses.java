package Stack;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class ReverseSubstringsBetweenEachPairofParentheses {

    //T.C : O(n^2)
    //S.C : O(n)
    public String reverseParentheses(String s) {
        Stack<Integer> openBracket = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket.push(result.length());
            } else if (ch == ')') {
                int start = openBracket.pop();
                reverse(result, start, result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSubstringsBetweenEachPairofParentheses().reverseParentheses("(ed(et(oc))el)"));
    }


}
