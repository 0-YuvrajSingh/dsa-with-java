package Array;

import java.util.Arrays;

public class PositiveAndNegative {
    public int[] signSwap(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for(int i = 0; i<n; i++) {
            if(nums[i] >= 0) {
                arr[posIndex] = nums[i];
                posIndex += 2;
            }
            else{
                arr[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        PositiveAndNegative obj = new PositiveAndNegative();

        int[] nums1 = {3, 1, -2, -5, 2, -4};
        int[] result1 = obj.signSwap(nums1);
        System.out.println("Case 1: " + Arrays.toString(result1));

        int[] nums2 = {1, -1, 2, -2, 3, -3};
        int[] result2 = obj.signSwap(nums2);
        System.out.println("Case 2: " + Arrays.toString(result2));

        int[] nums3 = {-5, -2, -3, 1, 2, 3};
        int[] result3 = obj.signSwap(nums3);
        System.out.println("Case 3: " + Arrays.toString(result3));
    }
}
