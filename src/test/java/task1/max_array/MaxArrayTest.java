package task1.max_array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class MaxArrayTest {
    @Test
    public void testMaxArray() {
        String[] a = {"1", "1", "1.2", "0.1", "0.0001", "1.1"};
        assertEquals(2.1, MaxArray.getMax(a), 1e-9);
    }
    @Test
    public void testMaxArrayClose() {
        String[] a = {"0.00001", "0.00002", "0.000015", "0.000001", "0.000015", "0.000001"};
        assertEquals(0.000035, MaxArray.getMax(a), 1e-9);
    }
    @Test
    public void testMaxArraySimple() {
        String[] a = {"10", "15", "14", "10", "5", "8", "10", "7"};
        assertEquals(25, MaxArray.getMax(a), 1e-9);
    }
}