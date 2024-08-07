package Sorting;

/**
 * @author : Kunal Sharma
 * @since : 12/07/24, Friday
 **/

//T.C : O(nlogn) in Average case, O(n^2) in worst case
//S.C : O(1) Auxiliary space
public class QuickSort {

    // in place sorting algorithm
    static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int pivotIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(arr, pivotIndex, high);

        return pivotIndex;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
