package leetcode.google.arraysandstrings;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t == null || s == null || s.length() == 0 || t.length() == 0) return "";
        int a[] = new int[256];
        Arrays.fill(a, -1);
        for (int c : s.toCharArray()) a[c] = 0;
        for (int c : t.toCharArray()) {
            if (a[c] == -1) return "";
            else a[c]++;
        }
        int start = 0, end = 0, len = Integer.MAX_VALUE, index = -1, total = t.length();
        while (end < s.length()) {
            char curr = s.charAt(end);
            if (a[curr] > 0) total--;
            a[curr]--;
            while (total == 0) {
                char c = s.charAt(start);
                if (len > (end - start + 1)) {
                    len = end - start + 1;
                    index = start;
                }
                if (a[c] >= 0) total++;
                a[c]++;
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(index, index + len);
    }

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "ABC", t = "CBA";
        MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
        String res = windowSubstring.minWindow(s, t);
        System.out.println("res = " + res);
    }
}
