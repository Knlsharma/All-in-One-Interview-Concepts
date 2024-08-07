package Stack.Collison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 13/07/24, Saturday
 **/

public class RobotCollisions {

//Using Stack
//T.C : O(nlogn)
//T.C : O(n)
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j])); //  O(nlogn)

        List<Integer> result = new ArrayList<>();

        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex); // push for right direction
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {  // pop for left direction
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex); // push top index on top
                    } else if (healths[topIndex] < healths[currentIndex]) { // deleting small health
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0; // equal health
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}
