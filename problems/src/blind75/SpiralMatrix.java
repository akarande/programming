package blind75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        List<Integer> result = new ArrayList<>();
        while (left <= right && up <= down) {
            // Left -> Right
            for (int i = left; i <= right; i++) result.add(matrix[left][i]);
            // Up -> Down
            for (int i = up + 1; i <= down; i++) result.add(matrix[i][right]);
            right--;
            // Right -> Left
            for (int i = right; i >= left; i--) result.add(matrix[down][i]);
            left++;
            // Down -> Up
            for (int i = down - 1; i >= up; i--) result.add(matrix[i][up]);
            up++;
            down--;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sp = new SpiralMatrix();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integerList = sp.spiralOrder(mat);
        System.out.println("integerList.toString() = " + integerList.toString());
    }
}
