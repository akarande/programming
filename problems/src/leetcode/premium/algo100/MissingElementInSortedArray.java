package leetcode.premium.algo100;

import java.util.ArrayList;
import java.util.List;

public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums[0], j = 0; list.size() < k; i++) {
            if (j < nums.length && nums[j] == i) j++;
            else {
                list.add(i);
            }
        }
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        MissingElementInSortedArray elementInSortedArray = new MissingElementInSortedArray();
        int a[] = {4, 7, 9 ,10};
        int k = 1;
        int ans = elementInSortedArray.missingElement(a, k);
        System.out.println("ans = " + ans);
    }
}
