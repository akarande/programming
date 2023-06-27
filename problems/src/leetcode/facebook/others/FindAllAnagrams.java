package leetcode.facebook.others;

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Set<Character> set = new HashSet<>();
        for (char c : p.toCharArray()) set.add(c);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                Set<Character> curr = new HashSet<>();
                int k = i, j = i;
                while(j < s.length() && curr.size() < set.size()) {
                    char t = s.charAt(j);
                    if (curr.contains(t) || !set.contains(t)) break;
                    if (set.contains(t)) curr.add(t);
                    j++;
                }
                if (set.size() == curr.size()) result.add(k);
                i = j;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagrams allAnagrams = new FindAllAnagrams();
        String s = "cbeababacd", p = "abc";
        List<Integer> indices = allAnagrams.findAnagrams(s, p);
        System.out.println("Arrays.toString(indices.toArray()) = " + Arrays.toString(indices.toArray()));
    }
}
