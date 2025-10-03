package Dp;

public class PartitionEqualSubset {

    // ---------------- 1. MEMOIZATION ----------------
    public boolean canPartitionMemo(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false; // odd sum cannot be partitioned
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[n][target + 1];
        return func(n - 1, target, nums, dp);
    }

    private boolean func(int idx, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return (nums[idx] == target);

        if (dp[idx][target] != null) return dp[idx][target];

        boolean notTake = func(idx - 1, target, nums, dp);
        boolean take = false;
        if (target >= nums[idx]) {
            take = func(idx - 1, target - nums[idx], nums, dp);
        }

        return dp[idx][target] = (take || notTake);
    }

    // ---------------- 2. TABULATION ----------------
    public boolean canPartitionTabu(int[] nums) {
        int n = nums.length;
        int target = 0;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }
        target = target / 2;

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j >= nums[i]) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }

    // ---------------- 3. SPACE OPTIMIZED TABULATION ----------------
    public boolean canPartitionSpaceOpt(int[] nums) {
        int n = nums.length;
        int target = 0;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }

        target = target / 2;
        boolean[] prev = new boolean[target + 1];

        prev[0] = true; // target is 0 means target already reached so true;

        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (j >= nums[i]) {
                    take = prev[j - nums[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        PartitionEqualSubset solver = new PartitionEqualSubset();

        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        int[] nums3 = {2, 2, 3, 5};

        // Run Memoization
        System.out.println("Memoization {1,5,11,5}: " + solver.canPartitionMemo(nums1));
        System.out.println("Memoization {1,2,3,5}: " + solver.canPartitionMemo(nums2));
        System.out.println("Memoization {2,2,3,5}: " + solver.canPartitionMemo(nums3));

        // Run Tabulation
        System.out.println("Tabulation {1,5,11,5}: " + solver.canPartitionTabu(nums1));
        System.out.println("Tabulation {1,2,3,5}: " + solver.canPartitionTabu(nums2));
        System.out.println("Tabulation {2,2,3,5}: " + solver.canPartitionTabu(nums3));

        // Run Space Optimized
        System.out.println("SpaceOpt {1,5,11,5}: " + solver.canPartitionSpaceOpt(nums1));
        System.out.println("SpaceOpt {1,2,3,5}: " + solver.canPartitionSpaceOpt(nums2));
        System.out.println("SpaceOpt {2,2,3,5}: " + solver.canPartitionSpaceOpt(nums3));
    }
}
