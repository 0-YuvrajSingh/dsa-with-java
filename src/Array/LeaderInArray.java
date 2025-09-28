package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderInArray {

    public void leaderInArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= 0; i< arr.length-1; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) {
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length-1]);
        System.out.println("Leaders: " + list);
    }

    public static void main(String[] args) {
        LeaderInArray obj = new LeaderInArray();

        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Array: " + Arrays.toString(arr1));
        obj.leaderInArray(arr1);

        int[] arr2 = {1, 2, 3, 4, 0};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        obj.leaderInArray(arr2);

        int[] arr3 = {7, 10, 4, 6, 5, 2};
        System.out.println("\nArray: " + Arrays.toString(arr3));
        obj.leaderInArray(arr3);
    }
}
