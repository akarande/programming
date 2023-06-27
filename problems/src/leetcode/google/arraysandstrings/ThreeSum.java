package leetcode.google.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author akarande
 **/
public class ThreeSum {
    Map<Integer, Integer> map;
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            res.addAll(twoSum(nums, nums[i]));
        }
        return new ArrayList<>(res);
    }

    List<List<Integer>> twoSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] - target;
            if (map.containsKey(curr)
                && map.get(curr) != map.get(target) && map.get(target) != map.get(nums[i])) {
                set.add(Arrays.asList(i, map.get(curr), map.get(target)));
            } else {
                map.put(nums[i], i);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int a[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum.threeSum(a);
        lists.stream().forEach(e -> System.out.println("e = " + e));
    }
}
