package dynamicprogramming;

import com.sun.jdi.IntegerValue;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author akarande
 **/
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0, n = cardPoints.length;
        for(int x : cardPoints) total += x;
        int nonWindowSum = 0, result = 0;
        for(int i = 0; i < n - k; i++) nonWindowSum += cardPoints[i];
        result = total - nonWindowSum;
        for(int i = n-k; i < n; i++) {
            nonWindowSum += cardPoints[i] - cardPoints[i - (n - k)];
            result = Math.max(result, total - nonWindowSum);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCards maximumPointsYouCanObtainFromCards = new MaximumPointsYouCanObtainFromCards();
        int a[] = {1,79,80,1,1,1,200,1};
        int k = 3;
        int ans = maximumPointsYouCanObtainFromCards.maxScore(a, k);
        System.out.println("ans = " + ans);
    }
}
