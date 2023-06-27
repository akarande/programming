package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * 1512. Number of Good Pairs
 * https://leetcode.com/problems/number-of-good-pairs/
 **/
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int sum[] = new int[101];
        int dp[] = new int[105];
        Arrays.fill(dp, -1);
        for(int n : nums) sum[n]++;
        int ans = 0;
        for(int i = 0; i < sum.length; i++) ans += f(sum[i], dp);
        return ans;
    }

    int f(int n, int[] dp) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (n - 1) + f(n - 1, dp);
    }

    public static void main(String[] args) {
        NumberOfGoodPairs numberOfGoodPairs = new NumberOfGoodPairs();
        int nums[] = {1,1,1,1,1,2,3,1,1,3};
        int ans = numberOfGoodPairs.numIdenticalPairs(nums);
        System.out.println("ans = " + ans);
    }
}
