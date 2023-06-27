package leetcode.practice2020;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author akarande
 * 1481. Least Number of Unique Integers after K Removals
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 **/
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Count the frequency of each element.
        for(int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        List<Integer> sortedKeys = map.entrySet()
            .stream()
            .sorted(Comparator.comparingInt(x -> x.getValue()))
            .map(e -> e.getKey())
            .collect(Collectors.toList());
        int n = k, count = 0, i = 0;
        while(n > 0) {
            for(; i < sortedKeys.size(); i++) {
                Integer key = sortedKeys.get(i);
                if(map.containsKey(key) && map.get(key) <= n) {
                    n -= map.get(key);
                    map.remove(key);
                    count++;
                } else {
                    n = 0;
                    break;
                }
            }
        }
        return sortedKeys.size() - count;
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals integersAfterKRemovals = new LeastNumberOfUniqueIntegersAfterKRemovals();
        int[]  arr = {2,1,1,3,3,3};//{4,3,1,1,3,3,2};//{5,5,4};
        int k = 3;
        int ans = integersAfterKRemovals.findLeastNumOfUniqueInts(arr, k);
        System.out.println("ans = " + ans);
    }
}
