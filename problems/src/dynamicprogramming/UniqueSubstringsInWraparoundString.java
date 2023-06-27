package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        if(p.length() == 1) return 1;
        int[] dp = new int[26];
        int count = 0;
        for(int i = 0; i < p.length(); i++) {
            char curr = p.charAt(i);
            if(i > 0 && (curr - p.charAt(i - 1) == 1 || p.charAt(i - 1) - curr == 25)) count += 1;
            else count = 1;
            dp[curr - 'a'] = Math.max(dp[curr - 'a'], count);
        }
        int ans = 0;
        ans = Arrays.stream(dp).sum();
        /*for(int i = 0; i < dp.length; i++) {
            ans += dp[i];
        }*/
        return ans;
    }

    public static void main(String[] args) {
        UniqueSubstringsInWraparoundString uniqueSubstringsInWraparoundString = new UniqueSubstringsInWraparoundString();
        String p = "zab";
        int ans = uniqueSubstringsInWraparoundString.findSubstringInWraproundString(p);
        System.out.println("ans = " + ans);
    }
}
