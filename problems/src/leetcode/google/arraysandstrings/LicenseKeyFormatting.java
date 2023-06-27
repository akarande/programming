package leetcode.google.arraysandstrings;

/**
 * @author akarande
 **/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        String refinedStr = cleanStr(s);
        int n = refinedStr.length();
        if (k >= n) return refinedStr;
        int firstDash = n % k;
        StringBuilder sb = new StringBuilder();
        if (firstDash == 0) {
            int j = 0, i = 0;
            while (i < n) {
                if (j == k) {
                    sb.append('-');
                    j = 0;
                }
                else {
                    sb.append(refinedStr.charAt(i++));
                    j++;
                }
            }
        } else {
            int j = 0;
            while (j < n && j < firstDash) {
                sb.append(refinedStr.charAt(j++));
            }
            if (j == firstDash) sb.append('-');
            int i = j;
            j = 0;
            while (i < n) {
                if (j == k) {
                    sb.append('-');
                    j = 0;
                } else {
                    sb.append(refinedStr.charAt(i++));
                    j++;
                }
            }
        }
        return sb.toString();
    }

    char checkForUpperCase(char c) {
        if (Character.isLetter(c)) return Character.toUpperCase(c);
        return c;
    }

    String cleanStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '-') continue;
            sb.append(checkForUpperCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {"a-a-a-a-", "5F3Z-2e-9-w", "2-5g-3-J", "2"};
        int k[] = {1, 4, 2, 2};
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        for (int i = 2; i < s.length - 1; i++) {
            String result = licenseKeyFormatting.licenseKeyFormatting(s[i], k[i]);
            System.out.println("result = " + result);
        }
    }
}
