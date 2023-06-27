package leetcode.practice2022;

import java.util.Arrays;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int left[] = new int[n];
        Arrays.fill(left, n + 1);
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }

        int right[] = new int[n];
        Arrays.fill(right, n + 1);
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) right[i] = 0;
            else if (i + 1 < n) right[i] = right[i + 1] + 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) ans = Math.max(ans, Math.min(left[i], right[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson closestPerson = new MaximizeDistanceToClosestPerson();
        int seats[] = {1, 0, 0, 0};
        int ans = closestPerson.maxDistToClosest(seats);
        System.out.println("ans = " + ans);
    }
}
