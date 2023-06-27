package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int g[][] = new int[m][n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0], col = positions[i][1];
            g[row][col] = 1;
            boolean visited[][] = new boolean[m][n];
            int totalIsland = 0;
            for (int j = 0; j < g.length; j++) {
                for (int k = 0; k < g[j].length; k++) {
                    if (g[j][k] == 1 && !visited[j][k]) {
                        countIsland(j, k, g, visited);
                        totalIsland++;
                    }
                }
            }
            ans.add(totalIsland);
        }
        return ans;
    }

    private void countIsland(int i, int j, int[][] g, boolean visited[][]) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || visited[i][j] || g[i][j] == 0) return;
        visited[i][j] = true;
        countIsland(i + 1, j, g, visited);
        countIsland(i, j + 1, g, visited);
        countIsland(i - 1, j, g, visited);
        countIsland(i, j - 1, g, visited);
    }

    public static void main(String[] args) {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int positions[][] = {{0, 0}, {1, 1}, {0, 1}};
        int m = 2, n = 2;
        List<Integer> integerList = numberOfIslandsII.numIslands2(m, n, positions);
        System.out.println("integerList.toString() = " + integerList.toString());

    }
}
