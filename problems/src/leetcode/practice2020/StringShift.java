package leetcode.practice2020;

/**
 * @author akarande
 **/
public class StringShift {

    public String stringShift(String s, int[][] shift) {
        StringBuilder curr = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < shift.length; i++) {
            //char c = curr.charAt(0);
            if (shift[i][0] == 0) {
                String temp = curr.substring(0, shift[i][1]);
                curr = new StringBuilder(curr.substring(shift[i][1])).append(temp);
            } else if (shift[i][0] == 1) {
                String temp = curr.substring(0, n - shift[i][1]);
                curr = new StringBuilder(curr.substring(n - shift[i][1])).append(temp);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        StringShift stringShift = new StringShift();
        String s = "abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        String s1 = stringShift.stringShift(s, shift);
        System.out.println("s1 = " + s1);
    }
}
