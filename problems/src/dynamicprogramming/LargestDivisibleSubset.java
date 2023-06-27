package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akarande
 **/
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;

        // Sort the array
        Arrays.sort(nums);
        // Create the dp array and initialize it with 1 since, a number is divisible by itself.
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        // Also keep track of max subset elements
        int maxElements = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if(maxElements < dp[i]) {
                        maxElements = dp[i];
                    }
                }
            }
        }
        // Find the elements of the subset.
        int previousNum = -1;
        for(int i = dp.length - 1; i >= 0; i--) {
            // Check if the current dp value is max value and prev number is divisble by current number,
            // if prev == - 1 then its the first number in the loop
            if(dp[i] == maxElements && (previousNum % nums[i] == 0 || previousNum == -1)) {
                ans.add(nums[i]);
                maxElements--;
                previousNum = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int nums[] = {8, 4, 10, 240};
        List<Integer> integers = largestDivisibleSubset.largestDivisibleSubset(nums);
        for(Integer res : integers) {
            System.out.print(res + " ");
        }
    }
}
