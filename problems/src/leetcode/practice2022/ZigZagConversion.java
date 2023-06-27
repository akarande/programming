package leetcode.practice2022;

import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        if (s == null || s.length() < numRows) return s;
        StringBuilder a[] = new StringBuilder[numRows];
        for (int j = 0; j < a.length; j++) a[j] = new StringBuilder();
        int i = 0, k = 0, direction = 1;
        while (i < s.length()) {
            a[k].append(s.charAt(i++));
            if (k == numRows - 1) direction = -1;
            else if (k == 0)  direction = 1;
            k += direction;
        }
        StringBuilder ans = new StringBuilder();
        for (i = 0; i < a.length; i++) ans.append(a[i]);
        return ans.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String s =  "PAYPALISHIRIING";
        int numRows = 3;
        String result = zigZagConversion.convert(s, numRows);
        System.out.println("result = " + result);
    }
}
