package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, result, new ArrayList<>(), 0);
        System.out.println("All subset sums: " + result);
    }

    private static void generate(int[] nums, List<List<Integer>> result, List<Integer> curr, int idx) {

        result.add(new ArrayList<>(curr));
        for(int i = idx; i< nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            generate(nums, result, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
