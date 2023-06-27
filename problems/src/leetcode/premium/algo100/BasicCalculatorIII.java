package leetcode.premium.algo100;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < s.length(); k++) if (s.charAt(k) != ' ') sb.append(s.charAt(k));
        char a[] = sb.toString().toCharArray();
        int result = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        Stack<State> stack2 = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i])) {
                int num = 0;
                while (i < a.length && Character.isDigit(a[i])) num = num * 10 + (a[i++] - '0');
                i--;
                calculate(stack, num, sign);
            } else if (a[i] == '(') {
                stack2.push(new State(sign, stack));
                stack = new Stack<>();
                sign = '+';
            } else if (a[i] == ')') {
                int val = 0;
                while (!stack.isEmpty()) val += stack.pop();
                State state = stack2.pop();
                stack = state.stack;
                sign = state.operator;
                calculate(stack, val, sign);
            } else {
                sign = a[i];
            }
        }
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

    void calculate(Stack<Integer> stack, int num, int sign) {
        switch(sign) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
        }
    }

    class State {
        char operator;
        Stack<Integer> stack;
        public State(char op, Stack<Integer> st) {
            operator = op;
            stack = st;
        }
    }

    public static void main(String[] args) {
        BasicCalculatorIII calculatorIII = new BasicCalculatorIII();
        String s = "6-4/2";
        int ans = calculatorIII.calculate(s);
        System.out.println("ans = " + ans);
    }
}
