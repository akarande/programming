package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * 1363. Largest Multiple of Three
 * https://leetcode.com/problems/largest-multiple-of-three/
 * Reference: https://www.youtube.com/watch?v=sMGZXT_ylwY
 **/
public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int count[] = new int[10];
        long sum = 0;
        int mod1Smallest1 = Integer.MAX_VALUE, mod1Smallest2 = Integer.MAX_VALUE;
        int mod2Smallest1 = Integer.MAX_VALUE, mod2Smallest2 = Integer.MAX_VALUE;
        // Get the sum, and the count of each digit.
        for(int d : digits) {
            count[d]++;
            sum += d;
            if(d % 3 == 1) {
                if(mod1Smallest1 > d) {
                    mod1Smallest2 = mod1Smallest1;
                    mod1Smallest1 = d;
                } else if(mod1Smallest2 > d) {
                    mod1Smallest2 = d;
                }
            } else if(d % 3 == 2) {
                if(mod2Smallest1 > d) {
                    mod2Smallest2 = mod2Smallest1;
                    mod2Smallest1 = d;
                } else if(mod2Smallest2 > d) {
                    mod2Smallest2 = d;
                }
            }
        }
        if(sum % 3 == 1) {
            if(mod1Smallest1 != Integer.MAX_VALUE) {
                count[mod1Smallest1]--;
            } else if(mod2Smallest1 != Integer.MAX_VALUE && mod2Smallest2 != Integer.MAX_VALUE) {
                count[mod2Smallest1]--;
                count[mod2Smallest2]--;
            }
        } else if(sum % 3 == 2) {
            if(mod2Smallest1 != Integer.MAX_VALUE) {
                count[mod2Smallest1]--;
            } else if(mod1Smallest1 != Integer.MAX_VALUE && mod1Smallest2 != Integer.MAX_VALUE) {
                count[mod1Smallest1]--;
                count[mod1Smallest2]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = count.length - 1; i >= 0; i--) {
            int curr = count[i];
            while(curr-- > 0) sb.append(i);
        }
        String ans = sb.toString();
        while(ans.length() > 1 && ans.charAt(0) == '0') ans = ans.substring(1);
        return ans;
    }

    public static void main(String[] args) {
        LargestMultipleOfThree largestMultipleOfThree = new LargestMultipleOfThree();
        int[] digits = {1,1,1,2};//{9,8,6,8,6};//{5,8};//{8,6,7,1,0};
        String ans = largestMultipleOfThree.largestMultipleOfThree(digits);
        System.out.println("ans = " + ans);
    }
}
