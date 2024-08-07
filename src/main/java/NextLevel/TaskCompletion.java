package NextLevel;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kunal Sharma at 10/04/22 2:33 PM
 */
public class TaskCompletion {

    public static void main(String[] args) {

        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();

        int[] arr = {2, 5, 9, 8, 7, 1, 1};
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }
        boolean togleFlag = true;
        for (int i = 1; i <= 10; i++) {
            if (set.contains(i)) {
                // do nothing here
            } else {
                if (togleFlag) {
                    p1.append(",").append(i);
                    togleFlag = false;
                } else {
                    p2.append(",").append(i);
                    togleFlag = true;
                }

            }
        }

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
}
