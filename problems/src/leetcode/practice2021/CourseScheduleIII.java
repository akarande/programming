package leetcode.practice2021;

import java.util.Arrays;

/**
 * @author akarande
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/
 *
 **/
public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            if (a[1] < b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int lastDay = courses[courses.length - 1][1];
        int course = 0;
        int days = 0;
        /*Set
        for (int i = 0; i < courses.length; i++) {
            int[] curr = courses[i];
            if (curr[0])
        }*/
        return 0;
    }

    public static void main(String[] args) {
        CourseScheduleIII courseScheduleIII = new CourseScheduleIII();
        int a[][] = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        int ans = courseScheduleIII.scheduleCourse(a);
        System.out.println(ans);
    }
}
