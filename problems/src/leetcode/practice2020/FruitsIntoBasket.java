package leetcode.practice2020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akarande
 **/
public class FruitsIntoBasket {

    public int totalFruit(int[] tree) {
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while(end < tree.length) {
            int curr = tree[end];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.keySet().size() > 2) {
                int out = tree[start];
                maxLen = Math.max(maxLen, (end - start + 1));
                if(map.containsKey(out)) {
                    map.put(out, map.getOrDefault(out, 0) - 1);
                    if(map.get(out) <= 0) map.remove(out);
                }
                start++;
            }
            end++;
        }
        if(map.keySet().size() == 2) maxLen = (end - start);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public static void main(String[] args) {
        FruitsIntoBasket sol = new FruitsIntoBasket();
        int arr[] = {3,3,3,1,2,1,1,2,3,3,4};
        sol.totalFruit(arr);
    }
}
