package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 17/04/22 10:19 PM
 */
public class QuotientReminder {


    // find index 344 / 7  => 49.1428571429

    public static void main(String[] args) {

        int num = 344;
        int divisor = 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (num != 0) {
            int quot = num / divisor;
            int rem = num % divisor;

            if (i == 1) {
                sb.append(quot).append(".");
                i++;
            } else {
                sb.append(quot);
            }

            if (!map.containsKey(rem)) {
                map.put(rem, sb.length());
            } else {
                System.out.println("Repeating found " + map.get(rem));
                break;
            }

            rem = rem * 10;
            num = rem;
        }
        System.out.println(sb.toString());

    }
}
