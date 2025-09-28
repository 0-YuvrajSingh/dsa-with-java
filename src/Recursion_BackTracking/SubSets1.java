package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> result = new ArrayList<>();
        generate(nums, result, 0, 0);
        System.out.println("All subset sums: " + result);
    }

    private static void generate(int[] nums, List<Integer> result, int idx, int sum) {
        if (idx == nums.length) {
            result.add(sum);
            return;
        }
        generate(nums, result, idx + 1, sum + nums[idx]);
        generate(nums, result, idx + 1, sum);
    }
}