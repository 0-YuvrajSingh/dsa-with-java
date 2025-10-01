package Dp;

import java.util.Scanner;
import java.util.Arrays;

public class NinjaTraining {

    public static int memoizationFunction(int day, int last, int[][] arr, int[][] dp) {
        if (day == 0) {
            int maximum = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maximum = Math.max(maximum, arr[0][task]);
                }
            }
            return maximum;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        int maximum = Integer.MIN_VALUE;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = arr[day][task] + memoizationFunction(day - 1, task, arr, dp);
                maximum = Math.max(maximum, point);
            }
        }
        return dp[day][last] = maximum;
    }

    public static int tabulationFunction(int[][] nums, int[][] dp) {
        dp[0][0] = Math.max(nums[0][1], nums[0][2]);
        dp[0][1] = Math.max(nums[0][0], nums[0][2]);
        dp[0][2] = Math.max(nums[0][0], nums[0][1]);
        dp[0][3] = Math.max(nums[0][0], Math.max(nums[0][1], nums[0][2]));

        for (int day = 1; day < nums.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = nums[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[nums.length - 1][3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[][] points = new int[n][3];
        System.out.println("Enter points for each task for each day:");
        for (int day = 0; day < n; day++) {
            for (int task = 0; task < 3; task++) {
                points[day][task] = sc.nextInt();
            }
        }

        // Memoization DP
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int maxPoints = memoizationFunction(n - 1, 3, points, dp);
        System.out.println("Maximum points Ninja can earn (Memoization): " + maxPoints);

        // Tabulation DP
        int[][] DP = new int[n][4];
        for (int[] row : DP) {
            Arrays.fill(row, 0);
        }
        int maxPoint = tabulationFunction(points, DP);
        System.out.println("Maximum points Ninja can earn (Tabulation): " + maxPoint);

        sc.close();
    }
}
