package july2022;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class MinimumIsland {

    public int minimumIsland(int[][] g) {
        Set<String> visited = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 1 && !visited.contains(i + "," + j)) {
                    min = Math.min(dfs(i, j, visited, g), min);
                }
            }
        }
        return min;
    }

    int dfs(int i, int j, Set<String> visited, int[][] g) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[i].length || visited.contains(i + "," + j) || g[i][j] == 0) return 0;
        visited.add(i + "," + j);
        int size = 1;
        size += dfs(i + 1, j, visited, g);
        size += dfs(i, j + 1, visited, g);
        size += dfs(i - 1, j, visited, g);
        size += dfs(i, j - 1, visited, g);
        return size;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0, 0, 1, 0},
                     {1, 1, 0, 0, 1, 0},
                     {0, 1, 0, 0, 0, 0},
                     {0, 0, 0, 1, 1, 0},
                     {0, 0, 0, 1, 1, 0},
                     {0, 0, 0, 1, 0, 0},
        };
        MinimumIsland island = new MinimumIsland();
        int minIsland = island.minimumIsland(a);
        System.out.println("minIsland = " + minIsland);
    }
}
