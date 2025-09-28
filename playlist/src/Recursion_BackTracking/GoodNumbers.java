package Recursion_BackTracking;

import java.util.Scanner;

public class GoodNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        boolean result = checkGoodNumbers(arr, 0); // start recursion from index 0

        System.out.println(result ? "Yes" : "No");
    }

    // Recursive function to check the condition for all indices
    private static boolean checkGoodNumbers(int[] arr, int index) {
        if (index == arr.length) {
            return true; // base case: all elements checked
        }

        if ((index % 2 == 0 && arr[index] % 2 != 0) ||
                (index % 2 != 0 && !isPrime(arr[index]))) {
            return false; // fail condition
        }

        return checkGoodNumbers(arr, index + 1); // check next index
    }

    // Prime check function
    private static boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are not prime
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
