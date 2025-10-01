package Dp;

import java.util.Arrays;
import java.util.Scanner;

// By Memoization : T.C : O(N) S.C:O(N)+O(N);
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n, dp));
    }

    private static int fibo(int n, int[] dp) {
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }
}
