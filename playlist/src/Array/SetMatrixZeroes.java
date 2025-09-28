package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {

    public static void setMatrixZeroes(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int r : row) {
            for (int j = 0; j < columns; j++) {
                arr[r][j] = 0;
            }
        }

        for (int c : column) {
            for (int i = 0; i < rows; i++) {
                arr[i][c] = 0;
            }
        }
    }

    // 👉 Main method to test
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        setMatrixZeroes(arr);

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
