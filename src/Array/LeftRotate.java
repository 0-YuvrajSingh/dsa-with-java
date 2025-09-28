package Array;

import java.util.Arrays;

public class LeftRotate {

    public static int[] leftRotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return arr;
        k = k % n;

        int i = 0;
        int j = arr.length - 1;

        rotate(arr, i, k - 1);
        rotate(arr, k, j);
        rotate(arr, i, j);

        return arr;
    }

    public static void rotate(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        int[] nums = {-1, 0, 3, 6};
        int z = 3;


        System.out.println("Original Array: " + Arrays.toString(arr));
        int[] rotated = leftRotate(arr, k);
        System.out.println("Array after left rotating by " + k + ": " + Arrays.toString(rotated));
        System.out.println("Original Array: " + Arrays.toString(nums));
        int[] rotatedNums = leftRotate(nums, z);
        System.out.println("Array after left rotating by " + k + ": " + Arrays.toString(rotatedNums));
    }
}
