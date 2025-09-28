package Stack_Queue.Special;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangle(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxi = Math.max(maxi, arr[element] * (nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxi = Math.max(maxi, arr[element] * (nse-pse-1));
        }
        return maxi;
    }
}
