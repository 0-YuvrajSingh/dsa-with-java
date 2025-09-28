package Array;
import java.util.ArrayList;

public class RemoveDuplicates {


    public static void removeDuplicatesBetter(int[] arr) {
        if (arr == null || arr.length == 0) return;

        ArrayList<Integer> temp = new ArrayList<>();
        int unique = arr[0];
        temp.add(unique);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != unique) {
                unique = arr[i];
                temp.add(unique);
            }
        }

        // copy unique values back
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        // fill remaining places with ASCII of '_'
        for (int i = temp.size(); i < arr.length; i++) {
            arr[i] = '_';  // ASCII value 95
        }
    }

    // Optimal Approach(two Pointers):
    public static void removeDuplicatesOptimal(int[] arr) {
        int i = 0;
        int j = 1;
        int n = arr.length;
        while( j< n) {
            if(arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 2, 4, 4, 4, 4, 5, 5};

        System.out.print("Original: ");
        printArray(arr);

        removeDuplicatesOptimal(arr);

        System.out.print("After removing duplicates: ");
        printArray(arr);
    }

    // custom print method: if value == ASCII('_'), print as char
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == (int) '_') {
                System.out.print("_");
            } else {
                System.out.print(arr[i]);
            }
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
