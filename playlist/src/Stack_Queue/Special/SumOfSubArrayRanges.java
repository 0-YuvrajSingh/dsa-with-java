package Stack_Queue.Special;

import java.util.Stack;

public class SumOfSubArrayRanges {

    public long sumOfSubArrayRanges(int[] arr) {
        int n = arr.length;
        int[] nge = calNGE(arr);
        int[] nse = calNSE(arr);
        int[] pgee = calPGEE(arr);
        int[] psee = calPSEE(arr);

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            maxSum += (left * right) * arr[i];
        }

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            minSum += (left * right) * arr[i];
        }

        return maxSum - minSum;
    }

    // Previous Greater or Equal
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

    // Next Greater
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

    // Previous Smaller or Equal
    private static int[] calPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    // Next Smaller
    private static int[] calNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Test
    public static void main(String[] args) {
        SumOfSubArrayRanges solver = new SumOfSubArrayRanges();
        int[] arr = {1, 5 , 3};
        long result = solver.sumOfSubArrayRanges(arr);
        System.out.println("Sum of subarray ranges = " + result);
        // Expected: 4
    }
}
