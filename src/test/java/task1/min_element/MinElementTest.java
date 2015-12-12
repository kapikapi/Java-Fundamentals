package task1.min_element;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class MinElementTest {
    @Test
    public void testMinElementSimple() {
        double eps = 0.1;
        assertEquals("3", MinElement.getElement(eps).substring(0, MinElement.getElement(eps).indexOf("\n")));
        String[] strArr = MinElement.getElement(eps).substring(MinElement.getElement(eps).indexOf("\n")+1).split(" ");
        double[] arr = new double[strArr.length];
        for (int i=0; i<strArr.length; i++) {
            arr[i] = Double.parseDouble(strArr[i]);
        }
        double[] expected_array = {0.25, 0.1111111111, 0.0625};
        for (int i=0; i<arr.length; i++) {
            assertEquals(expected_array[i], arr[i], 1e-9);
        }

    }

    @Test
    public void testMinElement() {
        double eps = 0.0001;
        assertEquals("100", MinElement.getElement(eps).substring(0, MinElement.getElement(eps).indexOf("\n")));
    }

}