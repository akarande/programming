package leetcode.adobe;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int j = left + 1;
                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    left = j - 1;
                    int k = right - 1;
                    while (k >= 0 && nums[k] == nums[k + 1]) k--;
                    right = k + 1;
                }
                if (sum < 0) left++;
                else right--;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int nums[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(" = " + Arrays.toString(lists.toArray()));
    }
}
