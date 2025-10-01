package Dp;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i<n; i++){
            int take = nums[i];
            if(i > 1){
                take = nums[i] + prev2;
            }
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        System.out.println("By Space Optimized Tabulation Method : " + prev);

        System.out.println("By Space Tabulation Method : " + TabulationFunction(nums));

        // DP array for memoizationFunction:
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("By Space Memoization Method : " + memoizationFunction(n-1, nums, dp));
    }


    public static int TabulationFunction(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i<n; i++){
            int take = nums[i];
            if(i > 1){
                take = nums[i] + dp[i-2];
            }
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }

    public static int memoizationFunction(int idx, int[] arr, int[] dp){
        if(idx == 0) return arr[0];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int take = arr[idx] + memoizationFunction(idx-2, arr, dp);
        int notTake = memoizationFunction(idx-1, arr, dp);

        return dp[idx] = Math.max(take, notTake);
    }
}
