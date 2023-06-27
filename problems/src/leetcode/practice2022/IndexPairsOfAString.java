package leetcode.practice2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (words[i].charAt(0) == text.charAt(j)) {
                    int k = 0, t = j;
                    while (k < words[i].length() && t < text.length()) {
                        if (words[i].charAt(k) == text.charAt(t)) {
                            k++;
                            t++;
                        } else break;
                    }
                    if (k >= words[i].length()) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(j); ans.add(j + words[i].length() - 1);
                        res.add(ans);
                    }
                }
            }
        }
        int a[][] = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            a[i] = new int[] {res.get(i).get(0), res.get(i).get(1)};
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        return a;
    }

    public static void main(String[] args) {
        String s = "thestoryofleetcodeandme", words[] = {"story","fleet","leetcode"};
        IndexPairsOfAString pairsOfAString = new IndexPairsOfAString();
        int[][] ans = pairsOfAString.indexPairs(s, words);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("[" + ans[i][0] + "," + ans[i][1] + "]");
        }
    }
}
