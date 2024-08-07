package NextLevel;

/**
 * @author Kunal Sharma at 27/03/22 12:20 AM
 */
public class LongestConsecutiveSequenceOfOne {

    public static void main(String[] args) {
        System.out.println(getCountOfLongest1sConsecutive(new int[]{1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }

    public static int getCountOfLongest1sConsecutive(int[] arr) {
        int max_len = 0, temp_len = 0;

        for (int val : arr) {
            if (val == 0) {
                max_len = Math.max(temp_len, max_len);  // settling here
                temp_len = 0;

            } else {
                temp_len += 1;
            }

            if (temp_len > max_len) {
                max_len = temp_len;
            }
        }

        return max_len;
    }

}
