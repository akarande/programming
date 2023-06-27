package leetcode.microsoft;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') stack.push(')');
            else if (curr == '[') stack.push(']');
            else if (curr == '{') stack.push('{');
            else {
                System.out.println(curr);
                if (stack.isEmpty() || stack.peek() != curr) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParenthesis parenthesis = new ValidParenthesis();
        boolean isValid = parenthesis.isValid(s);
        System.out.println("isValid = " + isValid);
    }
}
