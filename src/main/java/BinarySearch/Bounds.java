package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 10/07/24, Wednesday
 **/
public class Bounds {

    public static int lowerBound(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

    public static int upperBound(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) <= target) { // Different comparison here
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

    public static int firstOccurrence(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else if (sorted.get(mid) > target) {
                right = mid - 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    public static int lastOccurrence(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else if (sorted.get(mid) > target) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(1, 3, 3, 5, 8);
        int target = 3;

        int lb = lowerBound(sortedList, target);
        int ub = upperBound(sortedList, target);

        System.out.println("Lower Bound of " + target + " is at index: " + lb); // 1
        System.out.println("Upper Bound of " + target + " is at index: " + ub); // 3
    }
}