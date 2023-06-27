package leetcode.adobe;

public class NthDigit {
    public int findNthDigit(int n) {
        int length = 1, first = 1;
        long digits = 9;
        while (n > length * digits) {
            n -= (length * digits);
            length++;
            first *= 10;
            digits *= 10;
        }
        first += (n - 1) / length;
        String curr = String.valueOf(first);
        return (curr.charAt((n - 1) % length) - '0');
    }

    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();
        int m = 3735;
        int nthDigit1 = nthDigit.findNthDigit(m);
        System.out.println("nthDigit1 = " + nthDigit1);
    }
}
