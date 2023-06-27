package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akarande
 **/
public class MostVisitedSectorInCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int a[] = new int[n + 1];
        for(int i = 0; i < rounds.length - 1; i++) {
            int curr = rounds[i];
            while(/*curr != rounds[i + 1]*/true) {
                a[curr]++;
                if(curr == n) {
                    curr = 1;
                    a[curr]++;
                }
                if(curr == rounds[i + 1]) break;
                curr++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) max = Math.max(max, a[i]);
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < a.length; i++) if(max == a[i]) res.add(i);
        return res;
    }

    public static void main(String[] args) {
        MostVisitedSectorInCircularTrack circularTrack = new MostVisitedSectorInCircularTrack();
        int n = 4, arr[]= {1,3,1,2};
        List<Integer> result = circularTrack.mostVisited(n, arr);
        result.stream().forEach(e -> System.out.print(e + " "));
    }
}
