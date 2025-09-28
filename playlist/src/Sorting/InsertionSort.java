package Sorting;

import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element, as the first element is "already sorted"
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // The element to be placed in the correct position
            int j = i - 1;

            // Shift elements of arr[0..i-1], that are greater than key, one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
