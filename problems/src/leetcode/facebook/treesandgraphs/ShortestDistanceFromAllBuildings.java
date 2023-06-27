package leetcode.facebook.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> buildings = new ArrayList<>();
        List<int[]> land = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) buildings.add(new int[]{i, j});
                else if (grid[i][j] == 0) land.add(new int[]{i, j});
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < land.size(); i++) {
            int[] a = land.get(i);
            int currSum = 0;
            for (int[] b : buildings) {
                currSum += Math.abs(b[0] - a[0]) + Math.abs(b[1] - a[1]);
            }
            min = Math.min(min, currSum);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings buildings = new ShortestDistanceFromAllBuildings();
        int g[][] = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        g = new int[][]{{1,0}};
        g = new int[][]{{1}};
        int ans = buildings.shortestDistance(g);
        System.out.println("ans = " + ans);
    }
}
