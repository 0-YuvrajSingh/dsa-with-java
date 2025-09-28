package Stack_Queue.Problems;

import java.util.Stack;

public class SmallerElement {
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < stack.peek()) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nse;
    }

    // Test method
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextSmallerElement(arr);

        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.print("\nNext Smaller Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
