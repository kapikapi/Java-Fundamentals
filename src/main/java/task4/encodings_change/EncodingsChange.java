package task4.encodings_change;

import java.io.*;

/**
 * Created by Elizaveta Kapitonova on 05.01.16.
 */
public class EncodingsChange {
    private String inputFileName;
    private String outputFileName;

    public EncodingsChange(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }


    public void makeFiles() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputFileName), "UTF8"));
             Writer out = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream(outputFileName), "UTF16"))){
            StringBuilder ss = new StringBuilder();
            String s;
            do {
                s=br.readLine();
                if (s!=null){
                    ss.append(s);
                }
            } while (s != null);

            System.out.println(ss);
            out.write(ss.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final String INPUT_FILE = "src/main/resources/EncodingsChangeFile.txt";
        final String OUTPUT_FILE = "src/main/EncodingsChangeFileUTF16.txt";
        EncodingsChange ec = new EncodingsChange(INPUT_FILE, OUTPUT_FILE);
        ec.makeFiles();
    }


}
