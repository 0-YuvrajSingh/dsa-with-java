package Recursion_BackTracking;

import java.util.Scanner;

public class IfAnySubsequenceWithSumK {
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

        boolean isThere = generate(nums, 0, k, 0);

        System.out.println(isThere);


        sc.close();

    }

    private static boolean generate(int[] nums, int idx, int k, int sum) {
        if(idx == nums.length){
            if(sum == k){
                return true;
            }
            return false;
        }

        sum += nums[idx];
        if(generate(nums, idx + 1, k, sum)){
            return true;
        }
        sum -= nums[idx];
        if(generate(nums, idx + 1, k, sum)){
            return true;
        }
        return false;
    }
}
