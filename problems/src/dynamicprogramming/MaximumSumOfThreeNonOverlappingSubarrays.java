package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 **/
public class MaximumSumOfThreeNonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        int[]arr = new int[len];
        int currSum = 0;
        for(int i = 0, j = i; i < len; i++) {
            while((j - i) < k) {
                currSum += nums[j++];
            }
            if(i > 0) {
                currSum = currSum - nums[i - 1];
            }
            arr[i] = currSum;
        }

        int left[] = new int[len];
        int right[] = new int[len];
        int maxIndex = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            left[i] = maxIndex;
        }
        maxIndex = len - 1;
        for(int i = len - 1; i >= 0; i--) {
            if(arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
            right[i] = maxIndex;
        }
        int res[] = new int[3];
        Arrays.fill(res, -1);
        int max = 0;
        for(int i = k; i < len - k; i++) {
            if(res[0] == -1 || arr[res[0]] + arr[res[1]] + arr[res[2]] < arr[left[i - k]] + arr[i] + arr[right[i + k]]) {
                res = new int[] {left[i - k], i, right[i + k]};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSumOfThreeNonOverlappingSubarrays maximumSumOfThreeNonOverlappingSubarrays = new MaximumSumOfThreeNonOverlappingSubarrays();
        int[] a = {1,2,1,2,6,7,5,1};
        int k = 2;
        int[] res = maximumSumOfThreeNonOverlappingSubarrays.maxSumOfThreeSubarrays(a, k);
        for(int x : res) System.out.print(x + ", ");
    }
}
