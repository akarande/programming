package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akarande
 **/
public class CustomSort {

    Map<Character, Integer> map = new HashMap<>();
    public List<String> customSort(char[] sortOrder, String[] list) {
        for(int i = 0; i < sortOrder.length; i++) map.put(sortOrder[i], i);
        Arrays.sort(list, (a, b) -> sort(a, b));
        List<String> result = new ArrayList<>();
        for(int i = 0; i < list.length; i++) result.add(list[i]);
        return result;
    }

    int sort(String a, String b) {
        if(b.contains(a)) return -1;
        else if(a.contains(b)) return 1;
        else {
            int i = 0, j = 0;
            while(i < a.length() && j < b.length()) {
                char c1 = a.charAt(i++), c2 = b.charAt(j++);
                if(c1 == c2) continue;
                else if(map.get(c1) < map.get(c2)) return -1;
                else if(map.get(c1) > map.get(c2)) return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        CustomSort customSort = new CustomSort();
        char c[] = {'b', 'c', 'a'};
        String[] list = new String[]{"aa", "ab", "bc", "abc", ""};
        List<String> strings = customSort.customSort(c, list);
        strings.stream().forEach(e -> System.out.print(e + " "));
    }
}
