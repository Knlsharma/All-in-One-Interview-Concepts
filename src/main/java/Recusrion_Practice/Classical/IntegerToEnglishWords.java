package Recusrion_Practice.Classical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class IntegerToEnglishWords {
    private static final Map<Integer, String> BELOW_TEN = new HashMap<>();
    private static final Map<Integer, String> BELOW_TWENTY = new HashMap<>();
    private static final Map<Integer, String> BELOW_HUNDRED = new HashMap<>();

    static {
        BELOW_TEN.put(0, "");
        BELOW_TEN.put(1, "One");
        BELOW_TEN.put(2, "Two");
        BELOW_TEN.put(3, "Three");
        BELOW_TEN.put(4, "Four");
        BELOW_TEN.put(5, "Five");
        BELOW_TEN.put(6, "Six");
        BELOW_TEN.put(7, "Seven");
        BELOW_TEN.put(8, "Eight");
        BELOW_TEN.put(9, "Nine");

        BELOW_TWENTY.put(10, "Ten");
        BELOW_TWENTY.put(11, "Eleven");
        BELOW_TWENTY.put(12, "Twelve");
        BELOW_TWENTY.put(13, "Thirteen");
        BELOW_TWENTY.put(14, "Fourteen");
        BELOW_TWENTY.put(15, "Fifteen");
        BELOW_TWENTY.put(16, "Sixteen");
        BELOW_TWENTY.put(17, "Seventeen");
        BELOW_TWENTY.put(18, "Eighteen");
        BELOW_TWENTY.put(19, "Nineteen");

        BELOW_HUNDRED.put(2, "Twenty");
        BELOW_HUNDRED.put(3, "Thirty");
        BELOW_HUNDRED.put(4, "Forty");
        BELOW_HUNDRED.put(5, "Fifty");
        BELOW_HUNDRED.put(6, "Sixty");
        BELOW_HUNDRED.put(7, "Seventy");
        BELOW_HUNDRED.put(8, "Eighty");
        BELOW_HUNDRED.put(9, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return convert(num).trim();
    }

    private String convert(int num) {
        if (num < 10) {
            return BELOW_TEN.get(num);
        }

        if (num < 20) {
            return BELOW_TWENTY.get(num);
        }

        if (num < 100) {
            return BELOW_HUNDRED.get(num / 10) + (num % 10 != 0 ? " " + BELOW_TEN.get(num % 10) : "");
        }

        if (num < 1000) {
            return BELOW_TEN.get(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convert(num % 100) : "");
        }

        if (num < 1_000_000) {
            return convert(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convert(num % 1000) : "");
        }

        if (num < 1_000_000_000) {
            return convert(num / 1_000_000) + " Million" + (num % 1_000_000 != 0 ? " " + convert(num % 1_000_000) : "");
        }

        return convert(num / 1_000_000_000) + " Billion" + (num % 1_000_000_000 != 0 ? " " + convert(num % 1_000_000_000) : "");
    }
}
