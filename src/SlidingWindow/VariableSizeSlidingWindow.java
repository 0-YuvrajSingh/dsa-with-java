package SlidingWindow;

public class VariableSizeSlidingWindow {
    /* The general steps to solve these questions by following below steps:
            In this type of sliding window problem, we increase our right pointer one by one till our condition is true.
            At any step if our condition does not match, we shrink the size of our window by increasing left pointer.
            Again, when our condition satisfies, we start increasing the right pointer and follow step 1.
            We follow these steps until we reach to the end of the array.
    */

    // This is used in case of longest/shortest subarray or substring.
    public static void variableWindow(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;

        while (right < n) {
            sum += arr[right];

            if (sum > k) {
                sum -= arr[left];
                left++;
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int k = 5;
        variableWindow(arr, k);
    }
}
