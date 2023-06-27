package leetcode.google.arraysandstrings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author akarande
 **/
public class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            int key = fruits[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> sortedValues = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int k = 0, n = sortedValues.size();
        int res = 0;
        while (k < 2 && k < n) {
            res += sortedValues.get(k);
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        FruitsIntoBaskets fruitsIntoBaskets = new FruitsIntoBaskets();
        int a[] = {3,3,3,1,2,1,1,2,3,3,4};
        int res = fruitsIntoBaskets.totalFruit(a);
        System.out.println("res = " + res);
    }
}
