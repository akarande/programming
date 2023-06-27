package leetcode.practice2022;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 && n2 >= 0) {
            int curr = (num1.charAt(n1--) - '0') + (num2.charAt(n2--) - '0') + carry;
            carry = curr / 10;
            sb.insert(0, curr % 10);
        }
        while (n1 >= 0) {
            int curr = (num1.charAt(n1--) - '0') + carry;
            carry = curr / 10;
            sb.insert(0, curr % 10);
        }
        while (n2 >= 0) {
            int curr = (num2.charAt(n2--) - '0') + carry;
            carry = curr / 10;
            sb.insert(0, curr % 10);
        }
        if (carry > 0) sb.insert(0, carry);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "298";
        String s2 = "567";
        AddStrings addStrings = new AddStrings();
        String ans = addStrings.addStrings(s1, s2);
        System.out.println("ans = " + ans);
    }
}
