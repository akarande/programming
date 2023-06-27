package miscellaneous;

import java.util.*;

/**
 * Code is not complete
 */
public class RemoveAnagrams {

    public String[] removeAnagrams(String arr[]) {
        if (arr == null || arr.length == 0) return new String[0];
        Set<String> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            char curr[] = arr[i].toCharArray();
            Arrays.sort(curr);
            String currStr  = new String(curr);
            set.add(currStr);
        }
        String res[] = new String[set.size()];
        int k = 0;
        for (String s : set) res[k++] = s;
        return res;
    }

    boolean isAnagram(Set<Character> set, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveAnagrams removeAnagrams = new RemoveAnagrams();
        String[] arr = {"Scaler", "Lacers", "Accdemy", "Academy"};
        String[] ans = removeAnagrams.removeAnagrams(arr);
        System.out.println(Arrays.toString(ans));
    }
}
