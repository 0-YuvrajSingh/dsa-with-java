package Stack_Queue.Problems;

import java.util.Arrays;

public class NumberOfNGEToRight {
    public static int[] numberOfNGEToRight(int[] nums, int[] indexes) {
        int n = nums.length;
        int m = indexes.length;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            int j = indexes[i];
            int curr = nums[j];
            for (int k = j + 1; k < n; k++) {
                if (nums[k] > curr) {
                    cnt++;
                }
            }
            arr[i] = cnt;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 9, 6, 1};
        int[] indexes = {0, 2, 3};
        int[] result = numberOfNGEToRight(nums, indexes);
        System.out.println("nums:    " + Arrays.toString(nums));
        System.out.println("indexes: " + Arrays.toString(indexes));
        System.out.println("result:  " + Arrays.toString(result));
    }
}
