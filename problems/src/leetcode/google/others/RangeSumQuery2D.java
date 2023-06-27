package leetcode.google.others;

/**
 * @author akarande
 **/
public class RangeSumQuery2D {

    int m[][];
    int sum[][];
    public RangeSumQuery2D(int[][] matrix) {
        m = matrix;
        sum = new int[m.length][m[0].length];
    }

    public void update(int row, int col, int val) {
        m[row][col] = val;
        prefixSum(row, col);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }

    private void prefixSum(int row, int col) {
        for (int i = row; i < sum.length; i++) {
            for (int j = col; j < sum[0].length; j++) {
                if (i == 0) continue;
                sum[i][j] += sum[i - 1][j];
            }
        }
    }
}
