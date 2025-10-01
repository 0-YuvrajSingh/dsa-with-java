package Dp;

import java.util.Scanner;

public class FrogJump {
    public static void main(String[] args) {
        // By Tabulation with Space Optimization
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int prev2 = 0;
        int prev1 = 0;
        for(int i = 1; i<n; i++) {
            int fs = prev1 + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }
        // Why prev1 ? Because curr now holds the value for index n it is wrong because we follow 0 based indexing
        System.out.println(prev1);
    }
}
