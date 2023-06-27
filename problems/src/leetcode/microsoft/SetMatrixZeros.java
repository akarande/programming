package leetcode.microsoft;

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] r = new boolean[rows];
        Arrays.fill(r, false);
        boolean[] c = new boolean[cols];
        Arrays.fill(c, false);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (r[i] || c[j]) matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SetMatrixZeros zeros = new SetMatrixZeros();
        zeros.setZeroes(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
