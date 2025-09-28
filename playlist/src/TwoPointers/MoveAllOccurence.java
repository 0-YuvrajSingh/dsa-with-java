package TwoPointers;

import java.util.Arrays;

public class MoveAllOccurence {
    static void moveToEnd(int[] arr, int element){
        /* Approach :
            count no of arr[i] != element
            if arr[i] != element : arr[count] = arr[i]
            count++
            fill the remaining positions with element
         */
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != element){
                arr[count] = arr[i];
                count++;
            }
        }
        while(count < arr.length){
            arr[count] = element;
            count++;
        }
        // Here, the pointers are count and i!
    }

    public static void main(String[] args){
        int[] arr = {1, 9, 2, 4, 2, 7 , 8 , 2};
        int element = 2;
        moveToEnd(arr, element);
        System.out.println(Arrays.toString(arr));
    }
}
