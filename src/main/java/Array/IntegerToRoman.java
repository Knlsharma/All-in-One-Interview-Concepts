package Array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class IntegerToRoman {

    private static final Map<Integer, String> ROMAN_MAP = new LinkedHashMap<>();

    static {
        ROMAN_MAP.put(1000, "M");
        ROMAN_MAP.put(900, "CM");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(400, "CD");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(90, "XC");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(40, "XL");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(9, "IX");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ROMAN_MAP.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (num >= value) {
                num -= value;
                result.append(symbol);
            }
        }

        return result.toString();
    }
}
