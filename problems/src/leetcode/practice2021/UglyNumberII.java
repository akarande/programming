package leetcode.practice2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author akarande
 **/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        int a2 = 2, a3 = 3, a5 = 5;
        set.add(1);
        while (set.size() < n) {
            List<Integer> currList = new ArrayList<>(set);
            List<Integer> temp = new ArrayList<>();
            for (int x : currList) {
                temp.add(x * a2);
                temp.add(x * a3);
                temp.add(x * a5);
            }
            set.addAll(temp);
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return  res.get(n - 1);
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        int result = uglyNumberII.nthUglyNumber(52);
        System.out.println("result = " + result);
    }
}
