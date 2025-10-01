package Dp;

import java.util.Scanner;

public class FrogJumpK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // By Tabulation Method :
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1; j<=k; j++){
                if(i - j >= 0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;

        }
        System.out.println(dp[n-1]);
        // T.C : O(N*K) S.C:O(N)

        frogJumpKSpace(arr, k);
    }
    public static void frogJumpKSpace(int[] arr, int k){
        int n = arr.length;
        int[] kSteps = new int[k]; // Circular Buffer
        kSteps[0] = 0;
        // Tabulation with Space Optimization worst case has same complexity as Tabulation Method
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k ; j++) {
                if(i - j >= 0){
                    int jump = kSteps[(i-j)%k] + Math.abs(arr[i] - arr[i-j]);
                    // why % k : if length passed of kSteps then store from 0 again
                    minSteps = Math.min(minSteps, jump);
                }
            }
            kSteps[i % k] = minSteps;
        }
        System.out.println(kSteps[(n-1) % k]);
        // T.C : O(N*K) S.C : O(K)
    }
}
