package Searching;

public class InsertPosition {
    public static int searchPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};

        System.out.println(searchPosition(arr, 5));
        System.out.println(searchPosition(arr, 2));
        System.out.println(searchPosition(arr, 7));
        System.out.println(searchPosition(arr, 0));
    }
}
