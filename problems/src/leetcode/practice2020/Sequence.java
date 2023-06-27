package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akarande
 **/
public class Sequence {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);
        int fact[] = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            sb.append(list.remove(k / fact[i]));
            k %= fact[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        int n = 4, k = 9;
        sequence.getPermutation(n, k);
    }
}
