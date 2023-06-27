package leetcode.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 0, m = matrix.length, n = matrix[0].length, row = 0, col = 0;
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, total = 0;
        while (total < m * n) {
            if (direction == 0) {
                while (j < n - col) {
                    result.add(matrix[i][j++]);
                    total++;
                }
                row++;
                direction = 1;
                j--;
            } else if (direction == 1) {
                while(i < m) {
                    result.add(matrix[i++][j]);
                    total++;
                }
                col++;
                direction = 2;
                i--;
            } else if (direction == 2) {
                while (j >= 0) {
                    result.add(matrix[i][j--]);
                    total++;
                }
                direction = 3;
                j++;
            } else if (direction == 3) {
                while (i >= row) {
                    result.add(matrix[i--][j]);
                    total++;
                }
                direction = 0;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralMatrix.spiralOrder(m);
        result.stream().forEach(e -> System.out.println("e = " + e));
    }
}
