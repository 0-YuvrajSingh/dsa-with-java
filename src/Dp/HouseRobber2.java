package Dp;

public class HouseRobber2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }
    // Aim in it is : First and Last can't be used as In Circular Array they are adjacent
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int robFirst = robLinear(nums, 0, n - 2);
        int robLast = robLinear(nums, 1, n - 1);

        return Math.max(robFirst, robLast);
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev = nums[start], prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            int take = nums[i] + (i > start + 1 ? prev2 : 0);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
