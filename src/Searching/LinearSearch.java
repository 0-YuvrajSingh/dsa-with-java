package Searching;

public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 17, 5, 8, -4, 0};
        int target = 17;
        System.out.println(linearSearch(arr, target));
    }
}
