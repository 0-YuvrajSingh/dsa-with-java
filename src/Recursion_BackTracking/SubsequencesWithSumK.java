package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsequencesWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), result, k, 0);

        System.out.println("Subsequences with sum " + k + ":");
        for(List<Integer> subsequence : result){
            System.out.println(subsequence);
        }

        sc.close();

    }
    private static void generate(int[] nums, int index, List<Integer> curr, List<List<Integer>> result, int k, int sum){
        if(index == nums.length){
            if(sum == k){
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(nums[index]);
        sum += nums[index];
        generate(nums, index+1, curr, result, k, sum);
        curr.removeLast();
        sum -= nums[index];
        generate(nums, index+1, curr, result, k, sum);
    }
}
