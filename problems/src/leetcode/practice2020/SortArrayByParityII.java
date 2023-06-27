package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 * 922. Sort Array By Parity II
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 **/
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for(int i = 0; i < A.length - 1; i++) {
            if(i % 2 == 0 && A[i] % 2 == 1) {
                int j = getIndex(i + 1, 0, A);
                if(j == - 1) break;
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            } else if(i % 2 == 1 && A[i] % 2 == 0) {
                int j = getIndex(i + 1, 1, A);
                if(j == -1) break;
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }

    int getIndex(int currIndex, int oddOrEven, int[] a) {
        for(int i = currIndex; i < a.length; i++) {
            if(oddOrEven == 0 && a[i] % 2 == 0 || oddOrEven == 1 && a[i] % 2 == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int A[] = {6,1,8,3,1,4,11,15,12,0};
        int[] arr = sortArrayByParityII.sortArrayByParityII(A);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
