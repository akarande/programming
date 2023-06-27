package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akarande
 **/
public class CanMakePalindromeFromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries) {
            System.out.println(getString(s, q[0], q[1]));
            ans.add(isPalindrome(getString(s, q[0], q[1]), q[2]));
        }
        return ans;
    }

    String getString(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while(start <= end) {
            sb.append(s.charAt(start++));
        }
        return sb.toString();
    }

    boolean isPalindrome(String s, int limit) {
        int count = 0;
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)) continue;
            else {
                count++;
            }
        }
        if(count <= limit) return true;
        return false;
    }

    public static void main(String[] args) {
        CanMakePalindromeFromSubstring palindromeFromSubstring = new CanMakePalindromeFromSubstring();
        String s = "abcda";
        int[][] q = {{3,3,0}, {1,2,0}, {0,3,1}, {0,3,2}, {0,4,1}};
        List<Boolean> booleanList = palindromeFromSubstring.canMakePaliQueries(s, q);
        for (Boolean b : booleanList) {
            System.out.print(b + " ");
        }
    }
}
