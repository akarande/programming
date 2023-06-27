package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class NumberAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        //int nums = Integer.numberOfTrailingZeros(n);
        //System.out.println("nums = " + nums);
        //return 0;
        return solve(0, new String(), 0, digits, n, new HashSet<>());
    }

    int solve(int pos, String currNum, int sum, String[] digits, int n, Set<String> seen) {
        if(pos >= digits.length || !currNum.isBlank() && Integer.valueOf(currNum) > n) return 0;
        for(int i = pos; i < digits.length; i++) {
            String temp = currNum + digits[i];
            if(seen.contains(temp)) continue;
            seen.add(temp);
            sum++;
            solve(i + 1, temp, sum, digits, n, seen);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberAtMostNGivenDigitSet givenDigitSet = new NumberAtMostNGivenDigitSet();
        String[] arr = {"1", "4", "9"};
        int n = 1000000000;
        int ans = givenDigitSet.atMostNGivenDigitSet(arr, n);
        System.out.println("ans = " + ans);
    }
}
