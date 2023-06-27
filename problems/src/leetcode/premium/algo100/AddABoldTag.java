package leetcode.premium.algo100;

import java.util.*;

public class AddABoldTag {
    public String addBoldTag(String s, String[] words) {
        List<int []> intervals = new ArrayList<>();
        for (String w : words) {
            int idx = -1;
            idx = s.indexOf(w, idx);
            while (idx != - 1) {
                intervals.add(new int[] {idx, idx + w.length()});
                idx++;
                idx = s.indexOf(s, idx);
            }
        }
        List<int[]> mergedIntervals = mergeIntervals(intervals);
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int[] interval : mergedIntervals) {
            sb.append(s.substring(prev, interval[0]));
            sb.append("<b>" + s.substring(interval[0], interval[1]) + "</b>");
            prev = interval[1];
        }
        if (prev < s.length()) sb.append(s.substring(prev));
        return sb.toString();
    }

    List<int []> mergeIntervals(List<int []> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] curr = intervals.get(0);
        List<int []> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (curr[1] >= interval[0]) curr[1] = Math.max(curr[1], interval[1]);
            else {
                result.add(new int[] {curr[0], curr[1]});
                curr = interval;
            }
        }
        result.add(new int[] {curr[0], curr[1]});
        return result;
    }

    public static void main(String[] args) {
        AddABoldTag boldTag = new AddABoldTag();
        String[] words = {"abc", "123"};
        String s = "abcxyz123";
        String ans = boldTag.addBoldTag(s, words);
        System.out.println("ans = " + ans);
    }
}
