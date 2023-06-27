package leetcode.practice2022;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.equals(goal)) {
            int a[] = new int[26];
            boolean canMatch = false;
            for (char c : s.toCharArray()) {
                a[c - 'a']++;
                if (a[c - 'a'] > 1) {
                    canMatch = true;
                    break;
                }
            }
            return canMatch;
        } else {
            if (s.length() != goal.length()) return false;
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) diff++;
            }
            System.out.println(diff);
            if (diff == 2) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        String s1 = "ab", s2 = "ba";
        boolean ans = buddyStrings.buddyStrings(s1, s2);
        System.out.println("ans = " + ans);
    }
}
