package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akarande
 **/
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        //int INF = Integer.MAX_VALUE;
        int dp[][] = new int[N][N];
        // Copy the last row.
        for(int i = 0; i < N; i++) dp[N - 1][i] = A[N - 1][i];
        for(int i = N - 2; i >= 0; i--) {
            // For each row get minimum of left, centre and right value.
            for(int j = 0; j < N; j++) {
                int curr = dp[i +  1][j];    // centre
                if(j > 0) curr = Math.min(curr, dp[i + 1][j - 1]);   // left
                if(j + 1 < N) curr = Math.min(curr, dp[i + 1][j + 1]); // right
                dp[i][j] = A[i][j] + curr;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumFallingPath minimumFallingPath = new MinimumFallingPath();
        int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
        int i = minimumFallingPath.minFallingPathSum(A);
        System.out.println("i = " + i);
    }
}
