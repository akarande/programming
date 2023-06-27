package leetcode.facebook.treesandgraphs;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (!map.containsKey(list.get(i))) map.put(list.get(i), new ArrayList<>());
                emailToName.put(list.get(i), name);
                if (i == 1) continue;
                map.get(list.get(i)).add(list.get(i - 1));
                map.get(list.get(i - 1)).add(list.get(i));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : emailToName.keySet()) {
            Set<String> set = new TreeSet<>();
            if (!visited.contains(email)) {
                visited.add(email);
                fillSet(email, map, set, visited);
                List<String> currList = new ArrayList<>(new ArrayList<>(set));
                currList.add(0, emailToName.get(email));
                ans.add(currList);
            }
        }
        return ans;
    }

    void fillSet(String email, Map<String, List<String>> map, Set<String> set, Set<String> visited) {
        set.add(email);
        for (String next : map.get(email)) {
            if (!visited.contains(next)) {
                visited.add(next);
                fillSet(next, map, set, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>(Arrays.asList());
        input.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        input.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        input.add(Arrays.asList("Mary","mary@mail.com"));
        input.add(Arrays.asList("John","johnnybravo@mail.com"));
        AccountsMerge merge = new AccountsMerge();
        List<List<String>> lists = merge.accountsMerge(input);
        for (List<String> list : lists) {
            for(String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }


    }
}
