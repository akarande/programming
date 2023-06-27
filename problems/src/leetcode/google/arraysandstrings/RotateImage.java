package leetcode.google.arraysandstrings;

/**
 * @author akarande
 **/
public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseArray(matrix);
    }

    void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i >= j) continue;
                int curr = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = curr;
            }
        }
    }

    void reverseArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int n = a[i].length;
            for (int j = 0; j < n / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][n - 1 - j];
                a[i][n - 1 - j] = temp;
            }
        }
    }

    void printArray(int a[][]) {
        for (int i = 0; i  < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        RotateImage image = new RotateImage();
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        image.rotate(a);
        image.printArray(a);
    }
}
