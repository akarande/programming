package dynamicprogramming;

/**
 * @author akarande
 **/
public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        return solve(n) == 1 ? true : false;
    }

    int solve(int remaining) {
        if(remaining <= 0) return 0;
        for(int i = 1; i * i <= remaining; i++) {
            if(solve(remaining - (i * i)) == 0) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        StoneGameIV stoneGameIV = new StoneGameIV();
        int n = 7;
        boolean ans = stoneGameIV.winnerSquareGame(n);
        System.out.println("ans = " + ans);
    }
}
