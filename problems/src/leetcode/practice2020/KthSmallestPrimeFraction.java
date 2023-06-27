package leetcode.practice2020;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author akarande
 **/
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Fraction> queue = new PriorityQueue<>((a, b) -> ((A[a.nr] * A[b.dr]) - (A[b.nr] * A[a.dr])));
        int n = A.length;
        for(int i = A.length - 1; i > 0; i--) {
            queue.offer(new Fraction(0, i));
        }
        int count = 0;
        Fraction fraction = null;
        while(count != K) {
            count++;
            fraction = queue.poll();
            if(A[fraction.nr + 1] != A[fraction.dr]) queue.offer(new Fraction(fraction.nr + 1, fraction.dr));
        }
        return new int[]{A[fraction.nr], A[fraction.dr]};
        //return solve2(A, K);
    }

    class Fraction {
        int nr, dr;
        public Fraction (int nr, int dr) {
            this.nr = nr; this.dr = dr;
        }
    }

    private int[] solve2(int[] A, int K) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> o1.p * o2.q - o2.p * o1.q);

        for (int i = A.length - 1; i >= 1; i--)
            heap.add(new Pair(0, A[0], A[i]));

        int count = 0;
        Pair pair = null;
        while (count != K) {
            pair = heap.remove();
            count++;
            if (A[pair.index + 1] != pair.q)
                heap.add(new Pair(pair.index + 1, A[pair.index + 1], pair.q));
        }

        int[] ans = { pair.p, pair.q };
        return ans;
    }

    class Pair{
        int index, p, q;
        public Pair(int index, int p, int q) {
            this.index = index; this.p = p; this.q = q;
        }
    }

    private int[] solve(int[] A, int K) {
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> ((A[a[0]] * A[b[1]]) - (A[b[0]] * A[a[1]])));
        for(int i = 0; i < A.length; i++) queue.offer(new int[]{i, A.length - 1});
        while(K-- > 0) {
            int[] curr = queue.poll();
            queue.offer(new int[]{curr[0], curr[1] - 1});
        }
        return new int[] {A[queue.peek()[0]], A[queue.peek()[1]]};
    }


    public static void main(String[] args) {
        KthSmallestPrimeFraction primeFraction = new KthSmallestPrimeFraction();
        int a[] = {1,2,3,5};
        int k = 3;
        int[] ans = primeFraction.kthSmallestPrimeFraction(a, k);
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
    }
}
