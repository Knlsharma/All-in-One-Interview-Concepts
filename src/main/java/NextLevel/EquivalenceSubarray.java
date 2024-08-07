package NextLevel;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kunal Sharma at 17/04/22 12:43 AM
 */
public class EquivalenceSubarray {

    // count of unique integers in sub-array = count of unique integer in array which is 7
    // count of sub-array = 7 unique character
    // exact k = almost (k) - almost (k -1)  => exact k =  (0,k) - ( 0, k -1 )

    public static void main(String[] args) {
        String str = "abbcdeecbbaffgabbc";
        Set<Character> set = new HashSet<>();
        for (Character ch : str.toCharArray()) {
            set.add(ch);
        }
        int k = set.size();

        int countLessThenK = CountOfSubstringLessThenKUniqueChar.solution(str, k);
        int countLessThenKMinus1 = CountOfSubstringLessThenKUniqueChar.solution(str, k - 1);

        int exact_count_for_k = countLessThenK - countLessThenKMinus1;
        System.out.println(exact_count_for_k);

    }


}
