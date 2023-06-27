package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/
 **/
public class CombinationSumIV {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return solve(nums, target);
    }

    private int solve(int[] nums, int target) {
        if(memo[target] != -1) return memo[target];
        int count = 0;
        for(int v : nums) {
            if(v <= target) count += solve(nums, target - v);
        }
        memo[target] = count;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int ans = combinationSumIV.combinationSum4(nums, target);
        System.out.println("ans = " + ans);
    }
}
