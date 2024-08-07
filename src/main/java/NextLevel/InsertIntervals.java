package NextLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 17/03/24, Sunday
 **/
public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;

        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);   // current end is smaller then new start
            } else if (intervals[i][0] > newInterval[1]) {
                break;  // new end is smaller then current start.
            } else {
                // Merge the intervals and check further
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                // update new interval every time to had updated interval
            }
            i++;
        }

        // push new interval once exit loop
        result.add(newInterval);

        // cover left over later
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
