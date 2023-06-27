package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author akarande
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=yQa2VSDhxA0&feature=youtu.be
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return  -1;
        if(amount == 0) return 0;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        int ans = coinChange.coinChange(coins, amount);
        System.out.println("ans = " + ans);
    }
}
