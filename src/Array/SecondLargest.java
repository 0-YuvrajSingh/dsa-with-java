package Array;

public class SecondLargest {

    public static int Optimal(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int secondLargestBetter(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array too small for second largest");
        }
        int largest = Optimal(arr);
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static int secondLargestOptimal(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array too small for second largest");
        }
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 20, 8, 20};
        int[] arr2 = {7, 7, 7};   // all equal
        int[] arr3 = {};          // empty

        System.out.println("Largest: " + Optimal(arr1));
        System.out.println("Second Largest (Better): " + secondLargestBetter(arr1));
        System.out.println("Second Largest (Optimal): " + secondLargestOptimal(arr1));

        try {
            System.out.println("Second Largest (all equal): " + secondLargestOptimal(arr2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Second Largest (empty): " + secondLargestOptimal(arr3));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
