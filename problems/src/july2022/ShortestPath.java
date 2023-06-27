package july2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author akarande
 **/
public class ShortestPath {

    int bfs(char source, char dest, Set<Character> visited) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);
        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                char curr = queue.poll();
                visited.add(curr);
                if (curr == dest) return level;
                for (char c : map.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(c)) {
                        queue.offer(c);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    Map<Character, List<Character>> map;
    public static void main(String[] args) {
        ShortestPath path = new ShortestPath();
        path.map = new HashMap<>();
        path.map.put('w', Arrays.asList('x', 'v'));
        path.map.put('x', Arrays.asList('y'));
        path.map.put('z', Arrays.asList('y', 'v'));
        path.map.put('v', Arrays.asList('w', 'z'));
        int distance = path.bfs('w', 'z', new HashSet<>());
        System.out.println("distance = " + distance);
    }
}
