package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author akarande
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * Reference: https://www.youtube.com/watch?v=cr6Ip0J9izc
 **/
public class MaximumProfitInJobScheduling {
    public class Job {
        int start, end, profit;
        public Job(int start, int end, int profit) {
            this.start = start; this.end = end; this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        // sort the collection
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        int dp[] = new int[jobs.length];
        dp[0] = jobs[0].profit;
        int max = dp[0];
        for(int i = 1; i < jobs.length; i++) {
            // Current value of i is max profit until i-1 or just profit of running ith job
            dp[i] = Math.max(dp[i - 1], jobs[i].profit);
            for(int j = i - 1; j >= 0; j--) {
                /** For every job find the first job that does not overlap with this job,
                 *  and see if this job profit(jobs[i].profit) + profit till last non-overlapping jobs is greater(dp[j], since j < i)
                 *  the profit till last job.
                 */
                if(jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        /*MaximumProfitInJobScheduling maximumProfitInJobScheduling = new MaximumProfitInJobScheduling();
        int startTime[] = {1,2,3,3};
        int endTime[] = {3,4,5,6};
        int profit[] = {50, 10, 40, 70};
        int ans = maximumProfitInJobScheduling.jobScheduling(startTime, endTime, profit);
        System.out.println("ans = " + ans);*/
        int a[] = {31, 67, 3, 53, 22, 16};
        int[] arr = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
