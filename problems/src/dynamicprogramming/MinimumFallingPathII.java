package dynamicprogramming;

/**
 * @author akarande
 **/
public class MinimumFallingPathII {
    public int minFallingPathSum(int[][] arr) {
        int N = arr.length;
        int dp[][] = new int[N][N];
        for(int i = 0; i < N; i++) dp[N - 1][i] = arr[N - 1][i];
        for(int i = N - 2; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                int min = 100;
                for(int k = 0; k < N; k++) {
                    if(j == k) continue;
                    min = Math.min(min, dp[i + 1][k]);
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        int result = 100;
        for(int i = 0; i < N; i++) result = Math.min(result, dp[0][i]);
        return result;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        MinimumFallingPathII minimumFallingPathII = new MinimumFallingPathII();
        int result = minimumFallingPathII.minFallingPathSum(a);
        System.out.println("result = " + result);
    }
}
