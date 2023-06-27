package leetcode.practice2020;

/**
 * @author akarande
 **/
public class BasicCalculator {

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) if(c == ' ' || c == '(' || c == ')') continue; else sb.append(c);
        int result = 0;
        char op = '+';
        for(int i = 0; i < sb.length(); i++) {
            if(Character.isDigit(sb.charAt(i))) {
                int j = i, num = 0;
                while(j < sb.length() && Character.isDigit(sb.charAt(j))) {
                    num = num * 10 + Character.getNumericValue(sb.charAt(j));
                    j++;
                }
                i = j - 1;
                result += op == '+' ? num : -num;
            } else op = sb.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        int ans = basicCalculator.calculate(s);
        System.out.println("s = " + ans);
    }
}
