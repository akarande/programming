package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int curr[] = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(curr[0] <= intervals[i][0] && intervals[i][1] <= curr[1]) {
                count++;
            }
            curr = intervals[i];
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals coveredIntervals = new RemoveCoveredIntervals();
        int a[][] = {{3,10}, {4,10}, {5,11}};
        int ans = coveredIntervals.removeCoveredIntervals(a);
        System.out.println("ans = " + ans);
    }
}
