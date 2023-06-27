package leetcode.premium.algo100;

import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int inDegree[] = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < relations.length; i++) {
            inDegree[relations[i][1]]++;
            if (!map.containsKey(relations[i][0])) map.put(relations[i][0], new ArrayList<>());
            map.get(relations[i][0]).add(relations[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int curr = queue.poll();
                for (Integer x : map.getOrDefault(curr, new ArrayList<>())) {
                    inDegree[x]--;
                    if (inDegree[x] == 0) queue.offer(x);
                }
            }
            level++;
        }
        return level == 0 ? -1 : level;
    }

    public static void main(String[] args) {
        ParallelCourses parallelCourses = new ParallelCourses();
        int n = 999;
        int[][] relations = {{252,667},{92,775},{465,727},{584,794},{103,54},{889,766}};
        int ans = parallelCourses.minimumSemesters(n, relations);
        System.out.println("ans = " + ans);
    }
}
