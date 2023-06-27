package leetcode.practice2020;

/**
 * @author akarande
 **/
public class TicTacToe {
    public String tictactoe(int[][] moves) {
        int max = 3;
        int b[][] = new int[3][3];
        for(int i = 0; i < moves.length; i++) {
            b[moves[i][0]][moves[i][1]] = (i % 2) == 0 ? 1 : 2;
        }
        if(b[0][0] == b[0][1] && b[0][1] == b[0][2] ||
            b[0][0] == b[1][1] && b[1][1] == b[2][2] ||
            b[0][0] == b[1][0] && b[1][0] == b[2][0]) {
            if(b[0][0] == 1) return "A";
            if(b[0][0] == 2) return "B";
        } else if(b[1][0] == b[1][1] && b[1][1] == b[1][2]) {
            if(b[1][0] == 1) return "A";
            if(b[1][0] == 2) return "B";
        } else if(b[2][0] == b[2][1] && b[2][1] == b[2][2] ||
            b[2][0] == b[1][1] && b[1][1] == b[0][2]) {
            if(b[2][0] == 1) return "A";
            if(b[2][0] == 2) return "B";
        } else if(b[0][1] == b[1][1] && b[1][1] == b[2][1]) {
            if(b[0][1] == 1) return "A";
            if(b[0][1] == 2) return "B";
        } else if(b[0][2] == b[1][2] && b[1][2] == b[2][2]) {
            if(b[0][2] == 1) return "A";
            if(b[0][2] == 2) return "B";
        }
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b.length; j++) {
                if(b[i][j] == 0) return "Pending";
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {
        int a[][] = {{2,0},{1,1},{0,2},{2,1},{1,2},{1,0},{0,0},{0,1}};//{{2,2},{2,1},{1,0},{1,2},{0,0},{2,0}};
        TicTacToe ticTacToe = new TicTacToe();
        String ans = ticTacToe.tictactoe(a);
        System.out.println("ans = " + ans);
    }
}
