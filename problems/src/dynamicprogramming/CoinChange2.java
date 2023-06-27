package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 * Reference: https://leetcode.com/problems/coin-change-2/discuss/800754/simple-explained-solution
 **/
public class CoinChange2 {
    /*public int change(int amount, int[] coins) {
        if(amount == 0 || coins == null || coins.length == 0) return 0;
        return solve(0, 0, amount, coins);
    }

    int solve(int pos, int currSum, int amount, int[] coins) {
        if(pos >= coins.length || currSum > amount) return 0;
        if(currSum == amount) return 1;
        int ans = 0;
        for(int i = pos; i < coins.length; i++) {
            ans += solve(i, currSum + coins[i], amount, coins);
        }
        return ans;
    }*/

    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int ans = coinChange2.change(amount, coins);
        System.out.println("ans = " + ans);
    }
}
