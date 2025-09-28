package Array;

public class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        cyclicSort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        return arr.length;
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    // Can be solved by doing XOR of all values
    // Or, find sum of n natural number i.e., n * (n + 1) / 2 and sum of whole array
    // the solution  is their difference.

    private static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 6, 5, 3, 1, 2, 7};
        int ans = findMissingNumber(arr);
        System.out.println(ans);
    }
}
