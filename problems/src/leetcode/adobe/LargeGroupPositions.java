package leetcode.adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < s.length();) {
            int j = i, k = 0;
            if (s.charAt(j - 1) == s.charAt(j))  {
                k = j - 1;
                while (j < s.length() && s.charAt(j - 1) == s.charAt(j)) {
                    j++;
                }
                if (j - k > 2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(j - 1);
                    ans.add(temp);
                }
            }
            i = (j > i) ? j : i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LargeGroupPositions positions = new LargeGroupPositions();
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> ans = positions.largeGroupPositions(s);
        for (List l : ans) System.out.println(Arrays.toString(l.toArray()));
    }
}
