package NextLevel;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 18/03/24, Monday
 **/
public class MinimumNumberOfBallonToBurst {


    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int answer = 1;

        int[] prevBalloon = points[0];

        for(int i = 1; i < points.length; i++) {
            int[] currBallon = points[i];

            if(currBallon[0] > prevBalloon[1]) // no overlap
            {
                prevBalloon = currBallon;
                answer++;
            } else {
                prevBalloon[0] = Math.max(prevBalloon[0], currBallon[0]);
                prevBalloon[1] = Math.min(prevBalloon[1], currBallon[1]);

            }

        }

        return answer;

    }


}
