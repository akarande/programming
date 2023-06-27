package leetcode.practice2020;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author akarande
 * 1424. Diagonal Traverse II
 * https://leetcode.com/problems/diagonal-traverse-ii/submissions/
 **/
public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        seen.add("0-0");
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            // Add it to the answer.
            res.add(nums.get(curr[0]).get(curr[1]));
            String down = "" + (curr[0] + 1) + "-" + curr[1];
            if(curr[0] + 1 < nums.size() && curr[1] < nums.get(curr[0] + 1).size() && !seen.contains(down)) {
                queue.offer(new int[] {curr[0] + 1, curr[1]});
                seen.add(down);
            }
            String right = "" + curr[0] + "-" + (curr[1] + 1);
            if(curr[1] + 1 < nums.get(curr[0]).size() && !seen.contains(right)) {
                queue.offer(new int[] {curr[0], curr[1] + 1});
                seen.add(right);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }



    public static void main(String[] args) {
        /*leetcode.practice2020.DiagonalTraverseII diagonalTraverseII = new leetcode.practice2020.DiagonalTraverseII();
        List<List<Integer>> list = new ArrayList<>();
        *//*list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(7,8,9));*//*
        list.add(Arrays.asList(1,2,3,4,5));
        list.add(Arrays.asList(6,7));
        list.add(Arrays.asList(8));
        list.add(Arrays.asList(9,10,11));
        list.add(Arrays.asList(12,13,14,15,16));
        int[] diagonalOrder = diagonalTraverseII.findDiagonalOrder(list);
        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));*/
        int a[] = {3,1,2};
        System.out.println("a = " + Arrays.stream(a).max().getAsInt());
        System.out.println("a = " + Arrays.stream(a).min().getAsInt());
    }
}
