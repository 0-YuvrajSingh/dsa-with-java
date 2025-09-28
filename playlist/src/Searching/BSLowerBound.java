package Searching;

public class BSLowerBound {

    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 7, 10};
        int target = 4;

        int index = lowerBound(arr, target);
        System.out.println("Lower bound of " + target + " is at index: " + index);
    }
}
