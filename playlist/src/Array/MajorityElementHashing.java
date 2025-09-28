package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class MajorityElementHashing {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int value = freq.getOrDefault(num, 0);
            freq.put(num, value + 1);
        }

        for (Map.Entry<Integer, Integer> item : freq.entrySet()) {
            if (item.getValue() > nums.length / 2) { // correct condition: > n/2
                return item.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElementHashing sol = new MajorityElementHashing();

        int[] a = {2, 2, 1, 1, 2, 2, 2};
        int[] b = {3, 3, 4};
        int[] c = {1, 2, 3, 4};

        System.out.println("Input: " + Arrays.toString(a) + " -> Majority: " + sol.majorityElement(a));
        System.out.println("Input: " + Arrays.toString(b) + " -> Majority: " + sol.majorityElement(b));
        System.out.println("Input: " + Arrays.toString(c) + " -> Majority: " + sol.majorityElement(c));
    }
}
