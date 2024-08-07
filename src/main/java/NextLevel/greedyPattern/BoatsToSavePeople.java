package NextLevel.greedyPattern;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 04/05/24, Saturday
 **/
public class BoatsToSavePeople {


    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        int boatsCount = 0;

        while (start <= end) {


            if (people[start] + people[end] == limit) {
                start++;
                end--;
            } else if (people[start] + people[end] < limit) {
                start++;
                end--;
            } else {
                end--;
            }

            boatsCount++;
        }

        return boatsCount;
    }

    // 3 3 4 5     limit = 5

    // 1 2 2 3   3


}
