package leetcode.practice2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class PrintCellAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int size = 0;
        boolean found = false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int curr[] = new int[8];
            for (int j = 1; j < 7; j++) {
                curr[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            String s = Arrays.toString(curr);
            if (!set.contains(s)) {
                set.add(s);
                size++;
            } else {
                found = true;
                break;
            }
            cells = curr;
        }
        if (found) {
            N = N % size;
            for (int i = 0; i < N; i++) {
                int curr[] = new int[8];
                for (int j = 1; j < 7; j++) {
                    curr[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
                }
                cells = curr;
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        PrintCellAfterNDays printCellAfterNDays = new PrintCellAfterNDays();
        int a[] = {0,1,0,1,1,0,0,1};
        int n = 7;
        int[] response = printCellAfterNDays.prisonAfterNDays(a, 7);
        System.out.println("Arrays.toString(response) = " + Arrays.toString(response));
    }
}