package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class ShortestCommonSuperString {


    /*private String merge(String s1, String s2) {
        if(!s1.startsWith(s2) && !s1.endsWith(s2)) return s1 + s2;
        else {
            if(s1.startsWith(s2)) {
                int i = 0;
                while(i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i)) {
                    i++;
                }
                return
            }
        }
    }*/
    private int[]  getOverlap(String s1, String s2) {
        if(s1.length() > s2.length()) getOverlap(s2, s1);
        int overlap = 0, index = -1;
        for(int i = s1.length() - 1; i >= 0; i--) {
            String curr = s1.substring(0, i);
            if(s2.contains(curr)) {
               if(Math.abs(overlap) < curr.length()) {
                   overlap = -curr.length();
                   index = s2.indexOf(curr);
               }
            }
        }

        for(int i = 0; i < s1.length(); i++) {
            String curr = s1.substring(i);
            if(s2.contains(curr)) {
                if(Math.abs(overlap) < curr.length()) {
                    overlap = curr.length();
                    index = s2.indexOf(curr);
                }
            }
        }
        return new int[] {overlap, index};
    }

    public void buildGraph(String[] A) {
         int g[][] = new int[A.length][A.length];
         int maxX = 0, maxY = 0, max = 0;
         for(int i = 0; i < A.length; i++) {
             for(int j = 0; j < A.length; j++) {
                 if(i == j) continue;
                 int value[] = getOverlap(A[i], A[j]);
                 if(value[0] > 0) {
                     g[i][j] = value[0];
                 }
                 if(max < g[i][j]) {
                     max = g[i][j];
                     maxX = i;
                     maxY = j;
                 }
             }
         }
         boolean visited[] = new boolean[A.length];
         Arrays.fill(visited, false);

    }
}
