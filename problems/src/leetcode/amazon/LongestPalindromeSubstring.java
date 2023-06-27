package leetcode.amazon;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = new String();
        for (int i = 0; i < n; i++) {
            int j = i - 1, k = i + 1;
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            boolean isPalindrome = false;
            while (j >= 0 && k < n) {
                String curr = s.charAt(j) + sb.toString() + s.charAt(k);
                if (isPalindrome(curr)) {
                    sb.insert(0, s.charAt(j--));
                    sb.append(s.charAt(k++));
                    isPalindrome = true;
                } else break;
            }
            if (isPalindrome) {
                if (ans.length() < sb.length()) {
                    ans = sb.toString();
                }
            }
        }
        return ans;
    }

    boolean isPalindrome(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring palindromeSubstring = new LongestPalindromeSubstring();
        String s = "cbbd";
        String ans = palindromeSubstring.longestPalindrome(s);
        System.out.println("ans = " + ans);
    }
}
