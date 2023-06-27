package leetcode.adobe;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) swap(i, nums[i], nums);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) if (i + 1 != nums[i]) ans.add(i + 1);
        return ans;
    }

    void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInArray disappearedInArray = new FindAllNumbersDisappearedInArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        disappearedInArray.findDisappearedNumbers(nums);
    }
}
