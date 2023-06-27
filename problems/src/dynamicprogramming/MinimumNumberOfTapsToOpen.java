package dynamicprogramming;

/**
 * @author akarande
 * Leetcode: 1326. Minimum Number of Taps to Open to Water a Garden
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * Reference: https://www.youtube.com/watch?v=Pk128gC_sdw
 **/
public class MinimumNumberOfTapsToOpen {
    public int minTaps(int n, int[] ranges) {
        int minRange = 0, maxRange = 0, taps = 0, begin = 0;
        // Do until the entire garden is covered.
        while(maxRange < n) {
            for(int i = begin; i < ranges.length; i++) {
                // Check if there is an interval that starts at less than equal to minimumRange and the ends at greater than the maxRange
                if((i - ranges[i]) <= minRange && (i + ranges[i]) > maxRange) {
                    maxRange = i + ranges[i];   // Update the maxRange
                    begin = i;
                }
            }
            if(maxRange == minRange) return -1; // No range found
            minRange = maxRange;    // MaximumRange of current iteration becomes the minimum range for next iteration
            taps++;
        }
        return taps;
    }

    public static void main(String[] args) {
        MinimumNumberOfTapsToOpen minimumNumberOfTapsToOpen = new MinimumNumberOfTapsToOpen();
        int n = 5;
        int[] a = {3,4,1,1,0,0};
        int ans = minimumNumberOfTapsToOpen.minTaps(n, a);
        System.out.println("ans = " + ans);
    }
}
