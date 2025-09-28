package Array;

public class ModifiedKadaneAlgorithm {

    public static void maximumSum(int[] nums){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Case 1 (mixed array):");
        maximumSum(nums1);

        int[] nums2 = {-5, -2, -3, -7}; // fully negative array
        System.out.println("Case 2 (fully negative array):");
        maximumSum(nums2);
    }
}
