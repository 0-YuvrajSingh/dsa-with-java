package Array;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutiveSequence(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);
        int count = 1;
        int curr = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1) {
                curr++;
                count = Math.max(count, curr);
            } else if (arr[i] != arr[i + 1]) {
                curr = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        int[] arr1 = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("Longest consecutive length (arr1): " + obj.longestConsecutiveSequence(arr1));
        System.out.println("Longest consecutive length (arr2): " + obj.longestConsecutiveSequence(arr2));
    }
}
