package leetcode.google.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class NextClosestTime {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) if (c != ':') set.add(c - '0');
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3));
        int limit = 24 * 60;
        for (int i = 1; i <= limit; i++) {
            minutes++;
            minutes %= limit;
            if(isValid(minutes, set)) return getTime(minutes);
        }
        return time;
    }
    boolean isValid(int minutes, Set<Integer> set) {
        int hour = minutes / 60;
        minutes = minutes % 60;
        return set.contains(hour / 10) && set.contains(hour % 10) && set.contains(minutes / 10) && set.contains(minutes % 10);
    }
    String getTime (int minutes) {
        int hr = minutes / 60;
        int mins = minutes % 60;
        return ((hr < 10 ? ("0"+ hr) : hr) + "" + ":" + (mins < 10 ? ("0" + mins) : mins));
    }

    public static void main(String[] args) {
        NextClosestTime nextClosestTime = new NextClosestTime();
        String time = "23:59";///"19:34";
        String ans = nextClosestTime.nextClosestTime(time);
        System.out.println("ans = " + ans);
    }
}
