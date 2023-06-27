package july2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author akarande
 **/
public class Graphs {

    Map<Character, List<Character>> map;

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.map = new HashMap<>();
        graphs.map.put('a', Arrays.asList('b', 'c'));
        graphs.map.put('b', Arrays.asList('d'));
        graphs.map.put('c', Arrays.asList('e'));
        graphs.map.put('d', Arrays.asList('f'));
        graphs.map.put('e', Arrays.asList());
        graphs.map.put('f', Arrays.asList());
        graphs.dfs('a');
        System.out.println();
        graphs.bfs('a');
        System.out.println();
        graphs.dfsRecursive('a', new boolean[26]);
    }

    void dfs(char source) {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        stack.push(source);
        while (!stack.isEmpty()) {
            char curr = stack.pop();
            visited[curr - 'a'] = true;
            System.out.print(curr + " ");
            for (char c : map.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[c - 'a']) stack.push(c);
            }
        }
    }

    void dfsRecursive(char source, boolean[] visited) {
        if (visited[source - 'a']) return;
        System.out.print(source + " ");
        visited[source - 'a'] = true;
        for (char c : map.getOrDefault(source, new ArrayList<>())) {
            if (!visited[c - 'a']) dfsRecursive(c, visited);
        }
    }

    void bfs(char source) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);
        boolean visited[] = new boolean[26];
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                char curr = queue.poll();
                System.out.print(curr + " ");
                visited[curr - 'a'] = true;
                for (char c : map.get(curr)) {
                    if (!visited[c - 'a']) queue.offer(c);
                }
            }
        }
    }
}
