package Stack_Queue.Problems;

import java.util.Stack;

public class SumOfSubArrayMaximum {

    public static int sumOfSubArrayMaximum(int[] arr) {
        int n = arr.length;
        int[] nge = calNGE(arr);
        int[] pgee = calPGEE(arr);
        long sum = 0;
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            sum = (sum + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int) sum;
    }

    // Previous Greater or Equal Element
    private static int[] calPGEE(int[] arr) {
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }

    // Next Greater Element
    private static int[] calNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int result = sumOfSubArrayMaximum(arr);
        System.out.println("Sum of subarray maximums = " + result);
        // Expected output = 30
    }
}
