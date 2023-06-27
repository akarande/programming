package leetcode.practice2020;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author akarande
 **/
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Add all elements of A to tree map.
        for(int a : A) map.put(a, map.getOrDefault(a, 0) + 1);

        // Iterate over B and get the highest value than the current element of B otherwise next available one.
        int[] result = new int[A.length];
        Map.Entry<Integer, Integer> entry;
        int k = 0;
        for(int b : B) {
            entry = map.higherEntry(b);
            Integer key = (entry == null) ? map.firstKey() : entry.getKey();
            result[k++] = key;
            if(map.get(key) == 1) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        AdvantageShuffle advantageShuffle = new AdvantageShuffle();
        int a[] = {2,7,11,15};
        int[] b = {1,10,4,11};
        int[] ans = advantageShuffle.advantageCount(a, b);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
