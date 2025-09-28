package Stack_Queue.Problems;

import java.util.Stack;

public class LargestRectangleInHistogramBrute {
    public static int largestRectangle(int[] arr) {
        int n = arr.length;
        int[] nse = calNSE(arr);
        int[] pse = calPSE(arr);
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]*(nse[i]-pse[i]-1));
        }
        return maxi;
    }

    public static int[] calNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        // Store From Right To Left
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public static int[] calPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }


}
