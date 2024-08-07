package Backtracking.NormalExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 28/05/24, Tuesday
 **/
// TC :- O(2^n * n)
// SC :- O(1)
public class MaximumNumberOfAchieveTask {
        int m;
        int result = Integer.MIN_VALUE;

        public void solve(int idx, int count, int n, int[] resultant, List<int[]> requests) {
            if (idx == m) {
                boolean allZero = true;
                for (int x : resultant) {
                    if (x != 0) {
                        allZero = false;
                        break;
                    }
                }

                if (allZero) {
                    result = Math.max(result, count);
                }
                return;
            }

            int from = requests.get(idx)[0];
            int to = requests.get(idx)[1];

            resultant[from]--;
            resultant[to]++;
            solve(idx + 1, count + 1, n, resultant, requests);

            resultant[from]++;
            resultant[to]--;
            solve(idx + 1, count, n, resultant, requests);
        }

        public int maximumRequests(int n, int[][] requests) {
            List<int[]> requestsList = new ArrayList<>();

            for(int[] req : requests)
            {
                requestsList.add(req);
            }

            m = requestsList.size();

            int[] resultant = new int[n];

            solve(0, 0, n, resultant, requestsList);

            return result;

        }
    }
