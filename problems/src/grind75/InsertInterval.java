package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int curr[] = newInterval;
        List<int []> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (Math.max(curr[0], intervals[i][0]) <= Math.min(curr[1], intervals[i][1])) {
                curr = new int[] {Math.min(curr[0], intervals[i][0]), Math.max(curr[1], intervals[i][1])};
            } else {
                ans.add(intervals[i]);
            }
        }
        //ans.add(curr);
        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            int a[] = ans.get(i);
            if (a[0] > curr[0] && a[1] > curr[1]) ans.add(i, curr);
        }
        /*Collections.sort(ans, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });*/
        int res[][] = new int[ans.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        InsertInterval insertInterval = new InsertInterval();
        int[][] insert = insertInterval.insert(intervals, newInterval);
        Arrays.stream(insert).forEach(a -> System.out.println("Arrays.toString(a) = " + Arrays.toString(a)));
    }
}
