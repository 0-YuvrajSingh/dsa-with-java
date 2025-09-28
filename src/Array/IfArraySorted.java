package Array;

public class IfArraySorted {

    public static boolean ifSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4, 11, 13, 5, 17, 9};
        if(ifSorted(arr)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
