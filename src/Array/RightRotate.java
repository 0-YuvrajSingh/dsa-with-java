package Array;

import java.util.Arrays;

public class RightRotate {

    public static int[] rightRotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return arr;
        k = k % n; // handle k > n

        int i = 0;
        int j = arr.length - 1;

        rotate(arr, i, n - k - 1);
        rotate(arr, n - k, j);
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

        System.out.println("Original Array: " + Arrays.toString(arr));
        int[] rotated = rightRotate(arr, k);
        System.out.println("Array after right rotating by " + k + ": " + Arrays.toString(rotated));
    }
}
