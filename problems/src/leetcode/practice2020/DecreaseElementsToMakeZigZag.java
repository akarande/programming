package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 * 1144. Decrease Elements To Make Array Zigzag
 * https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
 **/
public class DecreaseElementsToMakeZigZag {
    public int movesToMakeZigzag(int[] nums) {
        int[] B = Arrays.copyOf(nums, nums.length);
        int n = nums.length, movesOdd = 0, movesEven = 0;
        // Run loop for even > odd indices
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(i + 1 < n) {
                    if(nums[i] <= nums[i + 1]) {
                        movesEven += nums[i + 1] - nums[i] + 1;
                        nums[i + 1] = nums[i] - 1;
                    }
                }
            } else {
                if(i + 1 < n) {
                    if(nums[i] >= nums[i + 1]) {
                        movesEven += nums[i] - nums[i + 1] + 1;
                        nums[i] = nums[i + 1] - 1;
                    }
                }
            }
        }

        // Run loop for odd > even indices
        nums = B;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(i + 1 < n) {
                    if(nums[i] >= nums[i + 1]) {
                        movesOdd += nums[i] - nums[i + 1] + 1;
                        nums[i] = nums[i + 1] - 1;
                    }
                }
            } else {
                if(i + 1 < n) {
                    if(nums[i] <= nums[i + 1]) {
                        movesOdd += nums[i + 1] - nums[i] + 1;
                        nums[i + 1] = nums[i] - 1;
                    }
                }
            }
        }
        return Math.min(movesEven, movesOdd);
    }

    public static void main(String[] args) {
        DecreaseElementsToMakeZigZag zigZag = new DecreaseElementsToMakeZigZag();
        int[] nums = {1,2,3};//{9,6,1,6,2};
        int ans = zigZag.movesToMakeZigzag(nums);
        System.out.println("ans = " + ans);
    }
}
