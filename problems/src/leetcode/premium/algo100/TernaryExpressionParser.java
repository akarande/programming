package leetcode.premium.algo100;

import java.util.Stack;

public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < expression.length()) stack.push(expression.charAt(i++));
        while (!stack.isEmpty() && stack.size() >= 5) {
            char op2 = stack.pop(); // second value
            stack.pop();    // :
            char op1 = stack.pop(); // first value
            stack.pop();     // ?
            char exp = stack.pop(); // exp to be evaluated
            if (exp == 'T' || exp >= '0' && exp <= '9') stack.push(op1);
            else stack.push(op2);
        }
        return new String(stack.pop() + "");
    }

    public static void main(String[] args) {
        TernaryExpressionParser parser = new TernaryExpressionParser();
        String s = "T?T?F:5:3";
        String ans = parser.parseTernary(s);
        System.out.println("ans = " + ans);
    }
}
