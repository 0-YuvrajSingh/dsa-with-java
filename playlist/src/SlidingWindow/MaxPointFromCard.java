package SlidingWindow;

public class MaxPointFromCard {

    public static void func(int[] arr, int k) {
        int lSum = 0;
        int rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += arr[i];
        }

        int maxSum = lSum;
        int right = arr.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];
            rSum += arr[right];
            right--;
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        func(arr, k);
    }
}

// TC = O(k) || SC = O(1)