package NextLevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Kunal Sharma at 03/04/22 4:41 PM
 */

public class FindAnagramMapping {

    public static void main(String[] args) {
        System.out.println(getIndexOfString("abbcddcab", "bdbabccad"));
    }

    private static String getIndexOfString(String inputStr, String mappingStr) {

        StringBuilder sb = new StringBuilder();

        Map<Character, Stack<Integer>> mapping = new HashMap<>();

        for (int i = mappingStr.length() - 1; i >= 0; i--) {
            char ch = mappingStr.charAt(i);
            Stack<Integer> stak;
            if (mapping.containsKey(ch)) {
                stak = mapping.get(ch);
            } else {
                stak = new Stack<>();
            }
            stak.push(i);
            mapping.put(ch, stak);
        }

        for (char ch : inputStr.toCharArray()) {
            if (mapping.containsKey(ch)) {
                Stack<Integer> stak = mapping.get(ch);
                Integer top_ele = stak.peek();
                sb.append(top_ele).append("    ");
                stak.removeElement(top_ele);
            }
        }

        return sb.toString();
    }
}
