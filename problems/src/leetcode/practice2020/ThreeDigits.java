package leetcode.practice2020;

/**
 * @author akarande
 **/
public class ThreeDigits {

    public String calculate(int x, int y, int z) {
        //double result = y * Math.log(x * 1.) / Math.log(z * 1.);
        double result = Math.pow(x, y) / (z * 1.);
        String s = String.valueOf(result);
        String a[] = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        String ans;
        for(int i = 0; i < Math.min(3, a[0].length()); i++) {
            sb.append(a[0].charAt(i));
        }
        ans = sb.toString();
        ans += ".";
        sb = new StringBuilder();
        for(int i = 0; i < Math.min(a[1].length(), 3); i++) {
            sb.append(a[1].charAt(i));
        }
        ans += sb.toString();
        return ans;
    }

    public static void main(String[] args) {
        ThreeDigits threeDigits = new ThreeDigits();
        int x = 1234, y = 56789, z = 123456;
        String ans = threeDigits.calculate(x, y, z);
        System.out.println(ans);
    }
}
