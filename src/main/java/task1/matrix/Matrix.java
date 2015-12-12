package task1.matrix;

import java.util.Scanner;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class Matrix {
    public static int[][] getMatrix(int n) {
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            a[i][i] = 1;
            a[i][n-i-1] = 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // matrix size
        scanner.close();
        for (int i=0; i<n; i++) {
            for (int j = 0; j<n; j++)
                System.out.print(getMatrix(n)[i][j]);
            System.out.println();
        }
    }
}