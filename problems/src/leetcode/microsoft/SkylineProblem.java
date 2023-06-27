package leetcode.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] a = new int[n * 2][2];
        int k = 0;
        for (int[] b : buildings) {
            if (k < a.length) {
                a[k] = new int[] {b[0], -b[2]};
                a[k + 1] = new int[] {b[1], b[2]};
            }
            k += 2;
        }
        Arrays.sort(a, (x, y) -> {
           if (x[0] == y[0]) return x[1] - y[1];
           return x[0] - y[0];
        });
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        queue.offer(0);
        int prev = 0, curr = 0;
        for (int i = 0; i < a.length; i++) {
            curr = a[i][1];
            if (curr < 0) queue.offer(-curr);
            else queue.remove(curr);
            if (!queue.isEmpty()) curr = queue.peek();
            if (prev != curr) result.add(Arrays.asList(a[i][0], curr));
            prev = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        SkylineProblem problem = new SkylineProblem();
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> skyline = problem.getSkyline(buildings);
        for (List list : skyline) {
            System.out.println("list = " + list);
        }
    }
}
