package TwoPointers;

public class TwoPointers {
    static boolean twoSum(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr= {-3, -2, -1, 0, 1, 2, 3};
        int target = 2;
        if(twoSum(arr, target)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }

    // Time Complexity : O(n);
    // Auxiliary Space = O(1);
}
