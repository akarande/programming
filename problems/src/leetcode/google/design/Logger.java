package leetcode.google.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author akarande
 **/
public class Logger {

    Map<String, Integer> nextTimestamp;
    Map<Integer, Set<String>> map;
    public Logger() {
        nextTimestamp = new HashMap<>();
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (nextTimestamp.containsKey(message)) {
            int nextTs = nextTimestamp.get(message);
             boolean shouldPrint = timestamp >= nextTs;
             if (shouldPrint) nextTimestamp.put(message, timestamp + 10);
             return shouldPrint;
        } else {
            nextTimestamp.put(message, timestamp + 10);
            Set<String> set = map.getOrDefault(timestamp, new HashSet<>());
            set.add(message);
            map.put(timestamp, set);
            return true;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        String[][] input = {{"0","A"},{"0","B"},{"0","C"},{"0","A"},{"0","B"},{"0","C"},{"11","A"},{"11","B"},{"11","C"},{"11","A"}};
            //{{"1","foo"},{"2","bar"},{"3","foo"},{"8","bar"},{"10","foo"},{"11","foo"}};
        for (String a[] : input) {
            boolean result = logger.shouldPrintMessage(Integer.valueOf(a[0]), a[1]);
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
