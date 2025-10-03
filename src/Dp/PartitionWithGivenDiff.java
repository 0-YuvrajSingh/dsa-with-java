package Dp;

import java.util.Arrays;

public class PartitionWithGivenDiff {

    // ------------------ MEMOIZATION ------------------
    public int countPartitionsMemo(int[] arr, int diff) {
        int MOD = (int) 1e9 + 7;
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        if ((total - diff) < 0 || (total - diff) % 2 != 0) return 0;
        int target = (total - diff) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, target, arr, dp, MOD);
    }

    private int solve(int idx, int target, int[] arr, int[][] dp, int MOD) {
        if (idx == 0) {
            if (target == 0 && arr[0] == 0) return 2; // pick or not pick
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if (dp[idx][target] != -1) return dp[idx][target];

        int notTake = solve(idx - 1, target, arr, dp, MOD);
        int take = 0;
        if (arr[idx] <= target) {
            take = solve(idx - 1, target - arr[idx], arr, dp, MOD);
        }
        return dp[idx][target] = (int) (((long) take + notTake) % MOD);
    }

    // ------------------ TABULATION ------------------
    public int countPartitionsTab(int[] arr, int diff) {
        int MOD = (int) 1e9 + 7;
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        if ((total - diff) < 0 || (total - diff) % 2 != 0) return 0;
        int target = (total - diff) / 2;

        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2; // pick or not pick
        } else {
            dp[0][0] = 1;
            if (arr[0] <= target) dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
                dp[i][j] = (int) (((long) take + notTake) % MOD);
            }
        }

        return dp[n - 1][target];
    }

    // ------------------ SPACE OPTIMIZED ------------------
    public int countPartitionsSpaceOpt(int[] arr, int diff) {
        int MOD = (int) 1e9 + 7;
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        if ((total - diff) < 0 || (total - diff) % 2 != 0) return 0;
        int target = (total - diff) / 2;

        int[] prev = new int[target + 1];

        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
            if (arr[0] <= target) prev[arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = 0;
                if (arr[i] <= j) take = prev[j - arr[i]];
                curr[j] = (int) (((long) take + notTake) % MOD);
            }
            prev = curr;
        }

        return prev[target];
    }

    // ------------------ MAIN METHOD ------------------
    public static void main(String[] args) {
        PartitionWithGivenDiff solver = new PartitionWithGivenDiff();

        int[] arr1 = {1, 1, 2, 3};
        int diff1 = 1;
        System.out.println("Memoization: " + solver.countPartitionsMemo(arr1, diff1)); // 3
        System.out.println("Tabulation: " + solver.countPartitionsTab(arr1, diff1));   // 3
        System.out.println("Space Optimized: " + solver.countPartitionsSpaceOpt(arr1, diff1)); // 3

        int[] arr2 = {0, 0, 1};
        int diff2 = 1;
        System.out.println("Memoization: " + solver.countPartitionsMemo(arr2, diff2));
        System.out.println("Tabulation: " + solver.countPartitionsTab(arr2, diff2));
        System.out.println("Space Optimized: " + solver.countPartitionsSpaceOpt(arr2, diff2));
    }
}
