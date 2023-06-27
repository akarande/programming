package leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutOffTreesForGolfEvent {
    int total = 0;
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (i == 0 && j == 0) continue;
                if (forest.get(i).get(j) == 1 || forest.get(i).get(j) == 0) continue;
                else count++;
            }
        }
        int ans = solve(0, 0, -1, forest, visited);
        if (forest.get(0).get(0) > 1) ans -= 1;
        return ans < count ? -1 : ans;
    }

    int solve(int i, int j, int prev, List<List<Integer>> forest, boolean[][] v) {
        if (i < 0 || i >= forest.size() || j < 0 || j >= forest.get(0).size()
                || forest.get(i).get(j) == 0 || v[i][j]) return 0;
        v[i][j] = true;
        int curr = forest.get(i).get(j);
        if (curr > 1 && curr > prev) {
            total += 1;
            prev = curr;
        }
        solve(i + 1, j, prev, forest, v);
        solve(i - 1, j, prev, forest, v);
        solve(i, j - 1, prev, forest, v);
        solve(i, j + 1, prev, forest, v);
        return total;
    }

    public static void main(String[] args) {
        CutOffTreesForGolfEvent golfEvent = new CutOffTreesForGolfEvent();
        List<List<Integer>> list = new ArrayList<>();
        /*list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(0,0,4));
        list.add(Arrays.asList(7,6,5));*/
        list.add(Arrays.asList(54581641,64080174,24346381,69107959));
        list.add(Arrays.asList(86374198,61363882,68783324,79706116));
        list.add(Arrays.asList(668150,92178815,89819108,94701471));
        list.add(Arrays.asList(83920491,22724204,46281641,47531096));
        list.add(Arrays.asList(89078499,18904913,25462145,60813308));
        int total = golfEvent.cutOffTree(list);
        System.out.println("total = " + total);
    }
}
