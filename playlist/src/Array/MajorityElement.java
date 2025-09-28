package Array;

import java.util.ArrayList;

public class MajorityElement {
    // If a number's count is more than n/2 it is majority element

    public int majorityElement(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

        int curr = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curr) {
                count++;
            } else {
                curr = arr[i];
                count = 1;
            }
            if (count > arr.length / 2) {
                return curr;
            }
        }
        return -1;
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= high) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = low; k <= high; k++) {
            arr[k] = temp.get(k - low);
        }
    }


    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] arr = {2, 2, 1, 1, 2, 2, 2};
        System.out.println("Majority Element: " + obj.majorityElement(arr));
    }
}
