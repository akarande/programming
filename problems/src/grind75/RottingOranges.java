package grind75;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int good = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) good++;
            }
        }
        System.out.println("IN: GOOD " + good);
        int level = 0;
        boolean firstPass = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int[] curr = queue.poll();
                if (grid[curr[0]][curr[1]] == 1) {
                    good--;
                    System.out.println("GOOD REMAINING: " + good);
                }
                for (int i = 0; i < dir.length; i++) {
                    int row = curr[0] + dir[i][0];
                    int col = curr[1] + dir[i][1];
                    if (row >= 0 && row < m && col >= 0 && col < n
                            && grid[row][col] == 1 && !visited[row][col]) {
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
            }
            if (!firstPass) level++;
            firstPass = false;
        }
        if (good > 0) return -1;
        return level;
    }

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] a = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int ans = rottingOranges.orangesRotting(a);
        System.out.println("ans = " + ans);
    }
}
