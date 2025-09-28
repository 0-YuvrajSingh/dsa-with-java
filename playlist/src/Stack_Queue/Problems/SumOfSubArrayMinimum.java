package Stack_Queue.Problems;

import java.util.Stack;

public class SumOfSubArrayMinimum {

    public static int sumOfSubArrayMinimum(int[] arr) {
        int n = arr.length;
        int[] nse = calNSE(arr);
        int[] psee = calPSEE(arr);
        long sum = 0;
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            sum = (sum + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int) sum;
    }

    // psee -> Previous Smaller Element and Equal
    private static int[] calPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    private static int[] calNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int result = sumOfSubArrayMinimum(arr);
        System.out.println("Sum of subarray minimums = " + result);
        // Expected output = 17
    }
}
