package Array;

public class KadaneAlgorithm {
    // To find Out maximum Sum of a subarray
    public static int maximumSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maximumSum(nums);
        System.out.println("Maximum Subarray Sum: " + result);
        int[] arr = {-2, -11 , -1 , -4, -9};
        int ans = maximumSum(arr);
        System.out.println("Maximum Subarray Sum: " + ans);
    }
}
