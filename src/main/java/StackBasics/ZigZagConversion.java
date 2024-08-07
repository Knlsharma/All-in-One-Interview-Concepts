package StackBasics;

/**
 * @author : Kunal Sharma
 * @since : 06/01/24, Saturday
 **/
public class ZigZagConversion {
    public String convert(String inputString, int numRows) {
        if (numRows == 1) return inputString;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int idx = i;
            int south = 2 * (numRows - 1 - i);
            int north = 2 * i;
            boolean goingSouth = true;
            while (idx < inputString.length()) {
                sb.append(inputString.charAt(idx));
                if (i == 0) {
                    idx += south;
                } else if (i == numRows - 1) {
                    idx += north;
                } else {
                    if (goingSouth) {
                        idx += south;
                    } else {
                        idx += north;
                    }
                    goingSouth = !goingSouth;
                }

            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }
}
