package max_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class MaxArray {
    public static double getMax(String[] a) {
        int n = a.length; // we consider correct input: n is even
        double arr[] = new double[n/2];
        for (int i=0; i<n/2; i++){
            arr[i] = Double.parseDouble(a[i]) + Double.parseDouble(a[n-i-1]);
        }
        double max = arr[0];
        for (double el : arr) {
            if (Double.compare(max, el) < 0) {
                max = el;
            }
        }
        return max;
    }

    public static void main(String[] args){
        try(InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader bufferRead = new BufferedReader(in)){
            String[] a = bufferRead.readLine().split(" ");
            System.out.println(getMax(a));
            bufferRead.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
