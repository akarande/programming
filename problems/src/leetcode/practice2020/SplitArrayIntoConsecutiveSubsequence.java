package leetcode.practice2020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author akarande
 * 659. Split Array into Consecutive Subsequences
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 **/
public class SplitArrayIntoConsecutiveSubsequence {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        while(!map.keySet().isEmpty()) {
            List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
            int count = 0;
            int prev = keys.get(0);
            while(map.containsKey(prev)) {
                map.put(prev, map.get(prev) - 1);
                if(map.get(prev) <= 0) map.remove(prev);
                count++;
                prev++;
            }
            if(count < 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequence splitArrayIntoConsecutiveSubsequence = new SplitArrayIntoConsecutiveSubsequence();
        int nums[] = {1,2,3,3,4,5};
        boolean isPossible = splitArrayIntoConsecutiveSubsequence.isPossible(nums);
        System.out.println("isPossible = " + isPossible);
    }

}
