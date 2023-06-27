package leetcode.practice2020;

/**
 * @author akarande
 * 858. Mirror Reflection
 * https://leetcode.com/problems/mirror-reflection/submissions/
 * Reference: https://leetcode.com/problems/mirror-reflection/discuss/607022/Number-of-trailing-zeros-(JavaScala)
 **/
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int lcm = (p * q) / gcd(p, q);
        if ((lcm/p) % 2 == 0) return 0;
        else {
            if ((lcm / q) % 2 == 0) return 1;
            return 0;
        }
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MirrorReflection mirrorReflection = new MirrorReflection();
        int p = 2, q = 1;
        int ans = mirrorReflection.mirrorReflection(p, q);
        System.out.println("ans = " + ans);
    }
}
