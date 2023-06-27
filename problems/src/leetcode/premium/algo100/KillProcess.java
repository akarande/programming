package leetcode.premium.algo100;

import java.util.*;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            Integer curr = ppid.get(i);
            if (!map.containsKey(curr)) map.put(curr, new ArrayList<>());
            map.get(curr).add(pid.get(i));
        }
        List<Integer> res = map.get(kill);
        if (res != null) res.add(kill);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>(Arrays.asList(1, 3, 10, 5));
        List<Integer> ppid = new ArrayList<>(Arrays.asList(3, 0, 5, 3));
        int kill = 5;
        KillProcess killProcess = new KillProcess();
        List<Integer> result = killProcess.killProcess(pid, ppid, kill);
        System.out.println("result.toArray().toString() = " + result.toString());
    }
}
