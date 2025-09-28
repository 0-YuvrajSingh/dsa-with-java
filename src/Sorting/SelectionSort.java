package Sorting;

import java.util.Arrays;

public class SelectionSort {

    // Selection Sort Algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // PSVM (Main Method)
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};
        System.out.println("Original Array: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
