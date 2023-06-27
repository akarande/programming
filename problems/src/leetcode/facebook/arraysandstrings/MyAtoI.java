package leetcode.facebook.arraysandstrings;

/**
 * @author akarande
 **/
public class MyAtoI {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1 && !Character.isDigit(s.charAt(0))) return 0;
        s = s.trim();
        if (s.charAt(0) == '+') s = s.substring(1);
        boolean isNegative = false;
        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && (c - '0') > 7) {
                    if (isNegative) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                num = num * 10 + (c - '0');
            } else {
                break;
            }
        }
        return isNegative ? -num : num;
    }

    public static void main(String[] args) {
        MyAtoI atoI = new MyAtoI();
        String s[] = {"-33.132494445", "42", "42.13341", "-21384", "-46.0", String.valueOf(Integer.MIN_VALUE), "4193 with words"};
        for (String t : s) System.out.println("atoI for [" + t + "] => " + atoI.myAtoi(t));
    }
}
