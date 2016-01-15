package task4.binary;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Elizaveta Kapitonova on 04.01.16.
 */
public class Binary {
    private String inputFileName;
    private String outputFileName;

    private static final String KEYWORDS[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

    public Binary(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }


    public void makeFiles() {
        String fc = readFile(inputFileName);
        writeFile(getMap(fc), outputFileName);
    }

    private Map<String, Integer> getMap(String fileContent) {
        Map<String, Integer> map = new HashMap<>();
        for (String k : KEYWORDS) {
            map.put(k, 0);
        }
        String[] fc = fileContent.split("[ .,;<>():]+");

        for (String word : fc) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word)+1);
            }
        }
        return map;
    }

    private String readFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try(InputStream inStream = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(inStream)){
            int numByte = bis.available();
            byte[] buf = new byte[numByte];
            bis.read(buf);
            for (byte b : buf) {
                fileContent.append((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent.toString();
    }

    private String mapToString(Map<String, Integer> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry item = (Map.Entry) it.next();
            if ((int)item.getValue() == 0) {
                it.remove();
            }
        }

        StringBuilder st = new StringBuilder();
        for (String key : map.keySet()) {
            st.append(key + "-" + map.get(key) + "\n");
        }
        return st.toString();
    }

    private void writeFile(Map<String, Integer> map, String outFileName) {
        String s = mapToString(map);
        System.out.println(s);
        byte[] bytes = s.getBytes();
        try (ByteArrayOutputStream b = new ByteArrayOutputStream();
             OutputStream f = new FileOutputStream(outFileName)) {
            b.write(bytes);
            b.writeTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final String INPUT_FILE = "src/main/resources/MaxArray.txt";
        final String OUTPUT_FILE = "src/main/KeyWords.txt";
        Binary binary = new Binary(INPUT_FILE, OUTPUT_FILE);
        binary.makeFiles();
    }
}
