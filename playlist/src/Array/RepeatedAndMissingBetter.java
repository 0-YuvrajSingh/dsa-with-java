package Array;

import java.util.HashMap;
import java.util.Map;

public class RepeatedAndMissingBetter {
    public static int[] find(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int repeated = -1;
        int missing = arr.length;
        for(int i = 0; i< arr.length; i++) {
            int value = freq.getOrDefault(arr[i], 0);
            freq.put(arr[i], value+1);
        }
        for (int i = 1; i <= arr.length; i++) {
            if (freq.containsKey(i)) {
                if (freq.get(i) == 2) {
                    repeated = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[] {repeated, missing};
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 3};
        int[] result = find(arr);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]);
    }
}
