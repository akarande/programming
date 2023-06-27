package leetcode.practice2020;

import java.util.Set;

/**
 * @author akarande
 **/
public class MinimumIncrementToMakeArrayUnique {
    Set<Integer> set;
    public int minIncrementForUnique(int[] A) {
        int a[] = new int[40005];
        for(int i : A) a[i]++;
        int duplicates = 0, result = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] > 1) {
                duplicates += a[i] - 1;
                result -= i * (a[i] - 1);
            } else if (duplicates > 0 && a[i] == 0) {
                duplicates--;
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique makeArrayUnique = new MinimumIncrementToMakeArrayUnique();
        int A[] = {3,2,1,2,1,7};
        System.out.println("makeArrayUnique.minIncrementForUnique(A) = " + makeArrayUnique.minIncrementForUnique(A));
    }
}
