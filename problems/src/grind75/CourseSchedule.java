package grind75;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map.putIfAbsent(prerequisites[i][1], new HashSet<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            //
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        // Queue is empty means all courses have dependency on each other.
        if (queue.isEmpty()) return false;
        int count = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int curr = queue.poll();
                count++;
                if (count == numCourses) return true;
                // Get all the dependent courses for curr from the map.
                for (Integer x : map.getOrDefault(curr, new HashSet<>())) {
                    inDegree[x]--;
                    if (inDegree[x] == 0) queue.offer(x);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int numCourses = 2;
        int[][] req = {{1, 0}};
        boolean ans = courseSchedule.canFinish(numCourses, req);
        System.out.println("ans = " + ans);
    }
}
