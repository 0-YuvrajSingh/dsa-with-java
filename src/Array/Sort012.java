package Array;

import java.util.Arrays;

public class Sort012 {

    public void sortZeroOneTwo(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = findPivot(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public int findPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Sort012 sorter = new Sort012();
        int[] nums = {2, 0, 1, 2, 1, 0, 1, 2, 0};
        sorter.sortZeroOneTwo(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }
}
