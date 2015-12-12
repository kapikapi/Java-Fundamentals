package task1.tangent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class Tan {
    public static strictfp ArrayList<TanStep> getStepTan(double a, double b, double h) {
        ArrayList<TanStep> arr = new ArrayList<>();
        for (double step = a; step - b <= 1e-9; step += h) {
            double tan = Math.tan(step * 2) - 3;
            TanStep ts = new TanStep(step, tan);
            arr.add(ts);
            System.out.println(step + " " + tan);
        }
        return arr;
    }

    public static void main(String[] args) {
        double a, b, h;
        Scanner scanner = new Scanner(System.in);
        // let input be in format: a b h
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        h = scanner.nextDouble();
        scanner.close();
        getStepTan(a, b, h);
    }
}


class TanStep{
    double step;
    double tan;
    public TanStep(double s, double t) {
        step = s;
        tan = t;
    }
}