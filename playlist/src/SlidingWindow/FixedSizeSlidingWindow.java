package SlidingWindow;

public class FixedSizeSlidingWindow {
    /*  When to Use Sliding Window
        You can apply the sliding window technique when:

        The problem involves a contiguous sequence (subarray or substring).
        You need to find:
        => Maximum/Minimum sum in a fixed-size window.
        => Longest/Shortest subarray with certain conditions.
        => Count of distinct elements in a range.

        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    static int maxWindowSum(int[] arr, int n, int k){

        if(n <= k){
            System.out.println("Invalid");
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < n ; i++) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /* How to Identify Sliding Window Problems?
        These problems generally require Finding Maximum/Minimum Subarray, Substrings which satisfy some specific condition.
        The size of the subarray or substring ‘k’ will be given in some of the problems.

    */

    public static void main(String[] args){
        int[] arr = {-4, 7, -5, 11, 0, -3, 9};
        int n = 7;
        int k = 3;
        System.out.println(maxWindowSum(arr, n, k));
    }
}
