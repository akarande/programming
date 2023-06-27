package leetcode.google.treesandgraphs;

import java.util.Stack;

/**
 * @author akarande
 **/
public class DecodeString {

    String solve(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                count.push(num);
            } else if (s.charAt(i) == '[') {
                stack.push(ans.toString());
                ans = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder curr = new StringBuilder(stack.pop());
                int total = count.pop();
                while (total-- > 0) curr.append(ans);
                ans = curr;
                i++;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = "3[a2[c]]";
        String ans = decodeString.solve(s);//decodeString.decodeString(s);
        System.out.println("ans = " + ans);
    }
}
