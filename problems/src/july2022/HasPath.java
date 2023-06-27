package july2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author akarande
 **/
public class HasPath {

     Map<Character, List<Character>> map;
    boolean dfs(char source, char dest, boolean visited[]) {
        if (source == dest) return true;
        if (visited[source - 'a']) return false;
        visited[source - 'a'] = true;
        for (char c : map.getOrDefault(source, new ArrayList<>())) {
            if (!visited[c - 'a'] && dfs(c, dest, visited)) return true;
        }
        return false;
    }

    boolean bfs(char source, char dest, boolean visited[]) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);
        visited[source - 'a'] = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            char curr = queue.poll();
            if (curr == dest) return true;
            visited[curr - 'a'] = true;
            for (char c : map.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[c - 'a']) queue.offer(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasPath hasPath = new HasPath();
        hasPath.map = new HashMap<>();
        hasPath.map.put('f', Arrays.asList('g', 'i'));
        hasPath.map.put('g', Arrays.asList('h'));
        hasPath.map.put('h', Arrays.asList());
        hasPath.map.put('i', Arrays.asList('g', 'k'));
        hasPath.map.put('j', Arrays.asList('i'));
        hasPath.map.put('k', Arrays.asList());
        boolean hasValidPath = hasPath.dfs('f', 'k', new boolean[26]);
        System.out.println("HasValidPath = " + hasValidPath);
        boolean bfsHasValidPath = hasPath.bfs('f', 'k', new boolean[26]);
        System.out.println("bfsHasValidPath = " + bfsHasValidPath);
    }

}
