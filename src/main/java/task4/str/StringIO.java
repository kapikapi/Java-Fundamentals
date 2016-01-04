package task4.str;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Elizaveta Kapitonova on 05.01.16.
 */
public class StringIO {
    private static final String INPUT_FILE = "src/main/resources/MaxArray.txt";
    private static final String OUTPUT_FILE = "src/main/KeyWordsString.txt";

    private static final String KEYWORDS[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };


    public StringIO(String fileName, String outputFileName) {
        String fc = readFile(fileName);
        writeFile(getMap(fc), outputFileName);
    }

    private Map<String, Integer> getMap(String fileContent) {
        Map<String, Integer> map = new HashMap<>();
        for (String k : KEYWORDS) {
            map.put(k, 0);
        }

        String[] fc = fileContent.split("[ .,;<>():=]+");

        for (String word : fc) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word)+1);
            }
        }
        return map;
    }

    private String readFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), "UTF8"))){
            String s;
            do {
                s=br.readLine();
                fileContent.append(s);
            } while (s != null);
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
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outFileName), "UTF8"))) {
            out.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringIO stringIO = new StringIO(INPUT_FILE, OUTPUT_FILE);
    }
}
