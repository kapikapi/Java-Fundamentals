package min_element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Elizaveta Kapitonovai on 29.11.15.
 */
public class MinElement {
    public static String getElement(double eps) {
        int i = 1;
        double a_i = 0.25;
        int res = i;
        String s = "";
        while (a_i >= eps) {
            a_i = Math.pow((i+1), -2);
            s += a_i + " ";
            res = i;
            i++;
        }
        return res + "\n" + s;
    }

    public static void main(String[] args) {
        try(InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader bufferRead = new BufferedReader(in)){
            double eps = Double.parseDouble(bufferRead.readLine());
            System.out.println(getElement(eps));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
