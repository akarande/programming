package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author akarande
 **/
public class SortVersionNumbers {
    public void sortVersionNumners(String[] nums) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            String[] currList = nums[i].split("\\.");
            int a[] = new int[currList.length];
            int k = 0;
            while(k < a.length) {
                a[k] = Integer.valueOf(currList[k++]);
            }
            list.add(a);
        }
        Collections.sort(list, (a, b) -> {
            int len = Math.min(a.length , b.length);
            int i  = 0;
           while(i < len) {
               if(a[i] < b[i]) return -1;
               else if(a[i] > b[i]) return 1;
               i++;
           }
           if (i >= a.length && i >= b.length) return 0;
           if (i < a.length) return -1;
           return 1;
        });
        printList(list);
    }
    

    private void printList(List<int[]> list) {
        String a[] = new String[list.size()];
        for(int[] x : list) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < x.length; i++) {
                sb.append(x[i]).append(".");
            }
            String res = sb.substring(0, sb.length() - 1);
            System.out.println(res);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortVersionNumbers sortVersionNumbers = new SortVersionNumbers();
        String nums[] = {"1.1.2", "0.9.1", "1.1.0", "0.8.1", "1.2", "1.6", "1.3"};
        sortVersionNumbers.sortVersionNumners(nums);
    }
}
