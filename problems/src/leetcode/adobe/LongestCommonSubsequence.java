package leetcode.adobe;


import java.util.Arrays;

public class LongestCommonSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        int longest[] = new int[n];
        Arrays.fill(longest, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
            }
        }
        for (int k : longest) max = Math.max(k, max);
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        int[] nums = {4,10,4,3,8,9};
        int ans = subsequence.lengthOfLIS(nums);
        System.out.println("ans = " + ans);
    }
}
