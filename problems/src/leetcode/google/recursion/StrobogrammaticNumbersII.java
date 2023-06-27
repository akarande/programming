package leetcode.google.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author akarande
 **/
public class StrobogrammaticNumbersII {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n % 2 == 0) solve(new String(), n, res);
        else {
            solve("1", n, res);
            solve("8", n, res);
            solve("0", n, res);
        }
        return res;
    }

    void solve(String curr, int n, List<String> res) {
        if (curr.length() == n) res.add(curr);
        else {
            if (n - curr.length() > 2) solve ("0" + curr + "0", n, res);
            solve ("1" + curr + "1", n, res);
            solve ("6" + curr + "9", n, res);
            solve ("9" + curr + "6", n, res);
            solve ("8" + curr + "8", n, res);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        StrobogrammaticNumbersII numbersII = new StrobogrammaticNumbersII();
        List<String> result = numbersII.findStrobogrammatic(n);
        result.stream().forEach(e -> System.out.print(e + " "));
    }
}
