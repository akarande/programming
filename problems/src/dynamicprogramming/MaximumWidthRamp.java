package dynamicprogramming;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author akarande
 * 962. Maximum Width Ramp
 * https://leetcode.com/problems/maximum-width-ramp/
 **/
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            if(map.floorKey(A[i]) == null) map.put(A[i], i);
            else max = Math.max(max, i - map.get(map.floorKey(A[i])));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        int[] A = {9,8,1,0,1,9,4,0,4,1};
        int ans = maximumWidthRamp.maxWidthRamp(A);
        System.out.println("ans = " + ans);
        Arrays.stream(A).sum();
    }
}
