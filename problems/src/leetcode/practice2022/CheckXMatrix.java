package leetcode.practice2022;

public class CheckXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][n - 1 - i] == 0) return false;
            if (grid[i][i] == 0) return false;
            for (int j = 0; i != j && j < n; j++) {
                if (grid[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckXMatrix matrix = new CheckXMatrix();
        int g[][] = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        boolean ans = matrix.checkXMatrix(g);
        System.out.println("ans = " + ans);
    }
}
