package leetcode.practice2020;

import java.util.HashMap;

/**
 * @author akarande
 **/
public class SubArraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int begin = 0, end = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(end < A.length) {
            int curr = A[end];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if(map.size() == K) count++;
            else if(map.size() > K) {
                do {
                    if (map.get(A[begin]) == 1) map.remove(A[begin]);
                    else map.put(A[begin], map.getOrDefault(A[begin], 0) + 1);
                    begin++;
                    count++;
                }while(map.size() == K);
            }
            end++;
        }
        return count;
    }

    public static void main(String arg[]) {
        SubArraysWithKDifferentIntegers subArraysWithKDifferentIntegers = new SubArraysWithKDifferentIntegers();
        int arr[] = {1,2,1,2,3}, K = 2;
        int result = subArraysWithKDifferentIntegers.subarraysWithKDistinct(arr, K);
        System.out.println("result = " + result);
    }
}
