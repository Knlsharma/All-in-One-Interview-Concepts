package NextLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 31/12/23, Sunday
 **/
public class LetterCombination {

    public static final String[] codes = {"", "", "abc", "def", "efg", "hij", "klm", "nop", "qrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        return getLetterCombinations(digits, 0);
    }

    private List<String> getLetterCombinations(String digits, int index) {
        if (index == digits.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> myResult = new ArrayList<>();
        List<String> recList = getLetterCombinations(digits, index + 1);
        char ch = digits.charAt(index);
        String code = codes[ch - '0'];
        for (String recString : recList) {
            for (int i = 0; i < code.length(); i++) {
                char singleChar = code.charAt(i);
                myResult.add(singleChar + recString);

            }
        }

        return myResult;
    }
}
