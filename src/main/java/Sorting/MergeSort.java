package Sorting;

/**
 * @author : Kunal Sharma
 * @since : 12/07/24, Friday
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
    }


    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid); // Sort left half
            mergeSort(arr, mid + 1, right); // Sort right half
            merging(arr, left, mid, right); // Merge sorted halves
        }
    }

    private static void merging(int[] arr, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        // Create temporary arrays for left and right halves
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        // Copy data to temporary arrays
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr
        int i = 0, j = 0, k = left;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftLength) {
            arr[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightLength) {
            arr[k++] = rightArray[j++];
        }
    }


}
