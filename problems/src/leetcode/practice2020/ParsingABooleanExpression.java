package leetcode.practice2020;

import java.util.Stack;

/**
 * @author akarande
 **/
public class ParsingABooleanExpression {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Character> exprStack = new Stack<>();
        for(char curr : expression.toCharArray()) {
            if(isOperator(curr)) operatorStack.push(curr);
            else if(curr == '(' || curr == 't' || curr == 'f') exprStack.push(curr);
            else if(curr == ')') {
                char result = 't';
                char operator = operatorStack.peek();
                operatorStack.pop();
                if(operator == '!') {
                    if(!exprStack.isEmpty() && exprStack.peek() != '(') {
                        result = exprStack.peek() == 't' ? 'f' : 't';
                        exprStack.pop();
                    }
                } else if(operator == '&') {
                    while(!exprStack.isEmpty() && exprStack.peek() != '(') {
                        result = exprStack.peek() == 'f' ? 'f' : 't';
                        exprStack.pop();
                    }
                } else if(operator == '|') {
                    result = 'f';
                    while(!exprStack.isEmpty() && exprStack.peek() != '(') {
                        result = exprStack.peek() == 't' ? 't' : 'f';
                        exprStack.pop();
                    }
                }
                exprStack.pop();
                exprStack.push(result);
            }
        }
        return exprStack.peek() == 't' ? true : false;
    }


    private boolean isOperator(char c) {
        if(c == '|' || c == '&' || c == '!') return true;
        return false;
    }

    public static void main(String[] args) {
        ParsingABooleanExpression parsingABooleanExpression = new ParsingABooleanExpression();
        String expr = "|(f,t)";//"|(&(t,f,|(t,f,&(t,t))),!(t))";//"!(f)";//""|(&(t,f,t),!(t))";
        boolean evaluate = parsingABooleanExpression.parseBoolExpr(expr);
        System.out.println("evaluate = " + evaluate);
    }
}
