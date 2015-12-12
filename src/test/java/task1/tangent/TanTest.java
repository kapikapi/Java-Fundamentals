package task1.tangent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class TanTest {
    @Test
    public void testStep() {
        double a = 1;
        double b = 2;
        double h = 0.1;
        double[] stepArr = {1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] stepTanArr = new double[stepArr.length];
        for (int i=0; i<stepArr.length; i++) {
            stepTanArr[i] = Tan.getStepTan(a, b, h).get(i).step;
        }
        assertArrayEquals(stepArr, stepTanArr, 1e-9);
    }

    @Test
    public void testTan() {
        double a = 1;
        double b = 2;
        double h = 0.1;
        double[] expectedArr = {-5.1850398632615, -4.3738230567688, -3.91601428967341, -3.60159661308976, -3.35552983165118,
                -3.14254654307428, -2.94152614554, -2.73568309913, -2.50653327002, -2.2264439095, -1.84217871765};
        double[] tanArr = new double[expectedArr.length];
        for (int i=0; i<expectedArr.length; i++) {
            tanArr[i] = Tan.getStepTan(a, b, h).get(i).tan;
        }
        assertArrayEquals(expectedArr, tanArr, 1e-9);
    }
}