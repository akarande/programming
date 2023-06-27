package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * 1458. Max Dot Product of Two Subsequences
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 * Reference: https://www.youtube.com/watch?v=9IwRPijqVA4
 **/
public class MaxDotProducOfTwoSubsequence {

    int dp[][][];
    public int maxDotProduct(int[] n1, int[] n2) {
        dp = new int[n1.length][n2.length][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
        int ans = solve(0, 0, n1, n2, 0);
        if(ans == -1) {
            int max1 = Arrays.stream(n1).max().getAsInt();
            int max2 = Arrays.stream(n2).max().getAsInt();
            int min1 = Arrays.stream(n1).min().getAsInt();
            int min2 = Arrays.stream(n2).min().getAsInt();
            ans = Math.max(max1 * min2, max2 * min1);
        }
        return ans;
    }

    int solve(int i, int j, int[] n1, int[] n2, int used) {
        if(i >= n1.length || j >= n2.length) {
            if(used == 1) return 0;
            return -1;
        }
        if(dp[i][j][used] != Integer.MIN_VALUE) return dp[i][j][used];
        int r1 = n1[i] * n2[j] + solve(i + 1, j + 1, n1, n2, 1);
        int r2 = solve(i, j + 1, n1, n2, used);
        int r3 = solve(i + 1, j, n1, n2, used);
        return dp[i][j][used] = Math.max(r1, Math.max(r2, r3));
    }

    public static void main(String[] args) {
        int[] n1 = {2,1,-2,5};
        int[] n2 = {3,0,-6};
        MaxDotProducOfTwoSubsequence maxDotProducOfTwoSubsequence = new MaxDotProducOfTwoSubsequence();
        int ans = maxDotProducOfTwoSubsequence.maxDotProduct(n1, n2);
        System.out.println("ans = " + ans);
    }
}
