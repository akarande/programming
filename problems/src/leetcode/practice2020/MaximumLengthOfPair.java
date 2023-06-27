package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class MaximumLengthOfPair {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if(a[0] == b[0]) return  a[1] - b[1];
            return a[0] - b[0];
        });
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < pairs.length; i++) {
            boolean used[] = new boolean[pairs.length];
            Arrays.fill(used, false);
            int count = 1;
            int curr[] = pairs[i];
            used[i] = true;
            for(int j = i + 1; j < pairs.length; j++) {
                if(curr[1] < pairs[j][0] && !used[j]) {
                    used[j] = true;
                    count++;
                    curr = pairs[j];
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfPair maximumLengthOfPair = new MaximumLengthOfPair();
        int[][] arr = {{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        //int[][] arr = {{-10, -8,}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 0}, {-4, 7}};
        int longestChain = maximumLengthOfPair.findLongestChain(arr);
        System.out.println("longestChain = " + longestChain);
    }
}
