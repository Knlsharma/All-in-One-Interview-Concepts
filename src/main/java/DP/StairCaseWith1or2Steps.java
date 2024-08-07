package DP;

/**
 * @author Kunal Sharma at 15/04/22 11:30 PM
 */
public class StairCaseWith1or2Steps {
    public static void main(String[] args) {
        int floor = 4;
        int start = 1;
        System.out.println(calculateWaysToReach(start, floor));

    }

    private static int calculateWaysToReach(int start, int floor) {
        System.out.println("start " + start + " end " + floor);

        if (start < floor) {
            return calculateWaysToReach(start + 1, floor) + calculateWaysToReach(start + 2, floor);
        } else if (start == floor) return 1;
        else return 0;
    }

}
