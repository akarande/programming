package leetcode.google.arraysandstrings;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author akarande
 **/
public class OddEvenJumps {
    public int oddEvenJumps(int[] arr) {
        int result = 1;
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> higherEntry = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lowerEntry = map.floorEntry(arr[i]);

            if (higherEntry != null) {
                higher[i] = lower[(int)higherEntry.getValue()];
            }
            if (lowerEntry != null) {
                lower[i] = higher[(int)lowerEntry.getValue()];
            }
            if (higher[i]) result++;
            map.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        int[] arr = {10,13,12,14,15};
        int result = oddEvenJumps.oddEvenJumps(arr);
        System.out.println("result = " + result);
    }
}
