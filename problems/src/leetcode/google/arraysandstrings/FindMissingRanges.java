package leetcode.google.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akarande
 **/
public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long left = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > left) {
                String s = nums[i] - 1 == left ? left + "" : left + "->" + (nums[i] - 1);
                result.add(s);
            }
            left = (long)nums[i] + 1;
        }
        if (left <= upper) {
            String t = left == upper ? left + "" : left + "->" + upper;
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        int n[] = {0,1,3,50,75}, lower = 0, upper = 99;
        FindMissingRanges findMissingRanges = new FindMissingRanges();
        List<String> missingRanges = findMissingRanges.findMissingRanges(n, lower, upper);
        missingRanges.stream().forEach(r -> System.out.println(r));
    }
}
