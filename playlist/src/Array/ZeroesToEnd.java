package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroesToEnd {

    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i<n ;i++){
            if(arr[i] != 0) {
                temp.add(arr[i]);
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        for (int i = temp.size(); i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 3, -2};

        System.out.println("Original Array: " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After moving zeroes to end: " + Arrays.toString(arr));
    }
}
