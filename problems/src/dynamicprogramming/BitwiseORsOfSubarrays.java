package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        if(A == null || A.length == 0) return 0;
        Set<Integer> result = new HashSet<>();
        Set <Integer> previous = new HashSet<>();
        result.add(A[0]);
        previous.add(A[0]);
        for(int i = 1; i < A.length; i++) {
            result.add(A[i]);
            previous.add(A[i]);
            Set<Integer> temp = new HashSet<>();
            for(int x : previous) {
                temp.add(A[i] | x);
                result.add(A[i] | x);
            }
            previous = temp;
        }
        return result.size();
    }

    public static void main(String[] args) {
        BitwiseORsOfSubarrays bitwiseORsOfSubarrays = new BitwiseORsOfSubarrays();
        int[] A = {1,2,4};
        int ans = bitwiseORsOfSubarrays.subarrayBitwiseORs(A);
        System.out.println("ans = " + ans);
    }
}
