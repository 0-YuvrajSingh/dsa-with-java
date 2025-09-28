package Array;

import java.util.Arrays;

public class RepeatAndMissing {

    public static int[] find(int[] arr) {
        Arrays.sort(arr);
        int repeated = -1, missing = arr.length;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                repeated = arr[i];
            } else if(arr[i] > arr[i-1] + 1) {
                missing = arr[i-1] + 1;
            }
        }

        return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 5, 3};
        int[] arr2 = {1, 2, 2, 4};
        int[] arr3 = {1, 1};

        System.out.println(Arrays.toString(find(arr1))); // [3, 4]
        System.out.println(Arrays.toString(find(arr2))); // [2, 3]
        System.out.println(Arrays.toString(find(arr3))); // [1, 2]
    }
}
