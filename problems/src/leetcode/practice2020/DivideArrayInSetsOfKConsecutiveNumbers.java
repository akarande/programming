package leetcode.practice2020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author akarande
 * 1296. Divide Array in Sets of K Consecutive Numbers
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/submissions/
 **/
public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        while(!map.keySet().isEmpty()) {
            List<Integer> sortedKeySet = map.keySet().stream().sorted().collect(Collectors.toList());
            int count = 0;
            int prev = sortedKeySet.get(0);
            while(count < k) {
                if(map.containsKey(prev)) map.put(prev, map.get(prev) - 1);
                else return false;
                if(map.get(prev) <= 0) map.remove(prev);
                count++;
                prev++;
            }
        }
        return true;
    }

    // Using treemap
    public boolean isPossibleDivide2(int[] nums, int k) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        //Iterator iterator = map.keySet().iterator();
        while(!map.keySet().isEmpty()) {
            int prev = map.firstKey();
            int count = 0;
            while(count < k) {
                if(map.containsKey(prev)) map.put(prev, map.get(prev) - 1);
                else return false;
                if(map.get(prev) <= 0) map.remove(prev);
                count++;
                prev++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers  divideArrayInSetsOfKConsecutiveNumbers = new DivideArrayInSetsOfKConsecutiveNumbers();
        int a[] = {1,2,3,4};//{1,2,3,3,4,4,5,6};
        int k = 3;
        boolean ans = divideArrayInSetsOfKConsecutiveNumbers.isPossibleDivide2(a, k);
        System.out.println("ans = " + ans);
    }
}
