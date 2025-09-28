package Array;

import java.util.Arrays;

public class LargestElement {

    public static int Brute(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n - 1];
        // T.C = O(n log n) because of sorting
        // S.C = O(1) if in-place sorting, else O(n)
    }

    public static int Optimal(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int largest = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 9, 4, 7};

        int bruteAns = Brute(arr.clone());   // clone so sort doesn't mutate original
        int optAns   = Optimal(arr);

        System.out.println("Brute largest:   " + bruteAns);
        System.out.println("Optimal largest: " + optAns);
    }


}
