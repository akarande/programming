package leetcode.google.arraysandstrings;

/**
 * @author akarande
 **/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        int n1 = num1.length(), n2 = num2.length();
        int[] ans = new int[n1 + n2];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = Character.getNumericValue(num1.charAt(i));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = Character.getNumericValue(num2.charAt(j));
                int k = n1 - 1 - i + n2 - 1 - j;
                ans[k] += a * b;
                ans[k + 1] += ans[k] / 10;
                ans[k] = ans[k] % 10;
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans.length - 1; i >= 0; i--) {
            sb.append(ans[i] + "");
        }
        String res = sb.toString();
        while (res.charAt(0) == '0') res = res.substring(1);
        return res;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String n1 = "123", n2 = "456";
        String res = multiplyStrings.multiply(n1, n2);
        System.out.println("res = " + res);
    }
}
