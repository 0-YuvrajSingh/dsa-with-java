package Sorting;

import java.util.Arrays;

public class CyclicSort {

    // Cyclic Sort Algorithm (for arrays with elements in the range 1 to n)
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1; // Expected index for this element

            // Place element at its correct position if it's not already there
            if (arr[i] != arr[correctIndex]) {
                // Swap arr[i] and arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++; // Move to next index if already in correct position
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));

        cyclicSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
