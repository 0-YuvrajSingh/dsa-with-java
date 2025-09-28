package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class Union {

    public static int[] union(int[] arr, int[] nums) {
        int i = 0, j = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        while (i < arr.length && j < nums.length) {
            if (arr[i] == nums[j]) {
                if (temp.isEmpty() || temp.get(temp.size() - 1) != arr[i]) {
                    temp.add(arr[i]);
                }
                i++;
                j++;
            } else if (arr[i] < nums[j]) {
                if (temp.isEmpty() || temp.get(temp.size() - 1) != arr[i]) {
                    temp.add(arr[i]);
                }
                i++;
            } else {
                if (temp.isEmpty() || temp.get(temp.size() - 1) != nums[j]) {
                    temp.add(nums[j]);
                }
                j++;
            }
        }

        while (i < arr.length) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) != arr[i]) {
                temp.add(arr[i]);
            }
            i++;
        }

        while (j < nums.length) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) != nums[j]) {
                temp.add(nums[j]);
            }
            j++;
        }

        int[] newArray = new int[temp.size()];
        for (int k = 0; k < temp.size(); k++) {
            newArray[k] = temp.get(k);
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5, 6};

        int[] result = union(arr1, arr2);
        System.out.println("Union: " + Arrays.toString(result));
    }
}
