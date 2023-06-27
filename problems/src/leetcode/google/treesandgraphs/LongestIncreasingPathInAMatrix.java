package leetcode.google.treesandgraphs;

/**
 * @author akarande
 **/
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (dp[i][j] == 0) {
                    res = Math.max(res, dfs(i, j, Integer.MIN_VALUE, dp, matrix));
                }
            }
        }
        return res;
    }

    int dfs(int x, int y, int prev, int[][] memo, int[][] m) {
        if (x < 0 || x >= m.length || y < 0 || y >= m[0].length || m[x][y] <= prev) return 0;
        if (memo[x][y] != 0) return memo[x][y];
        int right = dfs(x + 1, y, m[x][y], memo, m);
        int down = dfs(x, y + 1, m[x][y], memo, m);
        int left = dfs(x - 1, y, m[x][y], memo, m);
        int up = dfs(x, y - 1, m[x][y], memo, m);
        memo[x][y] = Math.max(right, Math.max(down, Math.max(left, up))) + 1;
        return memo[x][y];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix pathInAMatrix = new LongestIncreasingPathInAMatrix();
        int m[][] = {{9,9,4}, {6,6,8}, {2,1,1}};
        int ans = pathInAMatrix.longestIncreasingPath(m);
        System.out.println("ans = " + ans);
    }
}
