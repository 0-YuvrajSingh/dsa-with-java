package Array;

import java.util.ArrayList;
import java.util.List;

public class XorK {
    // Return subarrays whose xor equals k
    public static List<List<Integer>> equalK(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr ^= arr[j];
                if (curr == k) {
                    List<Integer> sub = new ArrayList<>();
                    for (int p = i; p <= j; p++) {
                        sub.add(arr[p]);
                    }
                    result.add(sub);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        List<List<Integer>> subarrays = equalK(arr, k);
        System.out.println("Subarrays with XOR = " + k + ": " + subarrays);
    }
}
