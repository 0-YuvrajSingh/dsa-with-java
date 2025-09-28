package Revisit;

import java.util.Arrays;

public class NextPermutation {
    // Optimal Solution:
    public int[] nextPermutation(int[] arr) {
        int index = -1;
        int n = arr.length;
        for(int i = n-2; i>=0; i--) {
            if(arr[i] < arr[i+1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return reverse(arr, 0, n-1);
        }
        for(int i = n-1; i>=0; i--) {
            if(arr[i] > arr[index]) {
                swap(arr, i, index);
                break; // ✅ Important: swap once and break
            }
        }
        return reverse(arr, index+1, n-1);
    }

    private int[] reverse(int[] arr, int i, int j) {
        int left = i;
        int right = j;
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--
            ;
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ✅ main method
    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();

        int[] arr1 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Next Permutation: " + Arrays.toString(obj.nextPermutation(arr1)));

        int[] arr2 = {3, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Next Permutation: " + Arrays.toString(obj.nextPermutation(arr2)));

        int[] arr3 = {1, 1, 5};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Next Permutation: " + Arrays.toString(obj.nextPermutation(arr3)));
    }
}
