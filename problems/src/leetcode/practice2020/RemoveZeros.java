package leetcode.practice2020;

/**
 * @author akarande
 **/
public class RemoveZeros {
    public void moveZeroes(int[] nums) {
        int arr[] = new int[nums.length];
        //Arrays.fill(arr, 0);
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] > 0) arr[j++] = nums[i];
        }
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        nums = arr;
        System.out.println();
        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }

    public static void main(String[] args) {
        RemoveZeros removeZeros = new RemoveZeros();
        int arr[] = {0, 1, 0, 3, 12};
        removeZeros.moveZeroes(arr);
    }
}
