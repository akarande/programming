package leetcode.practice2020;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int num = n;
        while(true) {
            if(num == 1 || seen.contains(num)) break;
            seen.add(num);
            num = getSum(num);

        }
        return num == 1;
    }

    int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            int curr = n % 10;
            sum += (curr * curr);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int n = 19;
        System.out.println("n = " + happyNumber.isHappy(n));
    }
}
