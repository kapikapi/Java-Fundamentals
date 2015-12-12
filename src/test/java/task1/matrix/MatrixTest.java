package task1.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class MatrixTest {
    @Test
    public void testMatrix() {
        int n = 5;
        int[][] a = {{1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}};
        assertArrayEquals(a, Matrix.getMatrix(n));
    }
    @Test
    public void testMatrixBig() {
        int n = 10;
        int[][] a = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        assertArrayEquals(a, Matrix.getMatrix(n));
    }
}