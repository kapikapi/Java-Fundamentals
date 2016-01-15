package task3.regexp_html;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Elizaveta Kapitonova on 03.01.16.
 * 2nd half is not done yet
 */
public class FigureSearcher {
    private final static String HTML_PATH = "src/main/resources/Java.SE.03.Information handling_task_attachment.html";
    private StringBuilder htmlContent;
    private List<String> figureRefs;
    private List<Integer> numbers;

    public FigureSearcher(String htmlPath) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(HTML_PATH), "windows-1251"))){
            htmlContent = new StringBuilder();
            String s;
            do {
                s=br.readLine();
                htmlContent.append(s);
            } while (s != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        figureRefs = new ArrayList<>();
        setNumbersHTML();
    }

    private String setNumbersHTML() {
        /*
        (Рис. 14-б)
        (Рис. 8 г,д)
        (Рис. 8-г,д)
        (Рис. 6)
        На рисунке 11
        рисунка 17
        (рис. 8)
         */
        String openStrong = "<strong>";
        String closeStrong = "</strong>";
        String newHtmlContent = "";
        numbers = new ArrayList<>();
        String pattern = "(?:\\([Рр]ис.\\s?(\\d+)(?:[\\s-]?((?:[а-яА-Я],)*[а-яА-Я])?)?\\)|[Рр]исун(?:ок|ка|ке|ку|ком)\\s?(\\d+)(?:[\\s-]((?:[а-яА-Я],)*[а-яА-Я]))?)";
        Matcher m = Pattern.compile(pattern).matcher(htmlContent);
        int i=0;
        while (m.find()) {
            i++;
            String l = m.group();
            figureRefs.add(l);
            String s = m.group(1);
            numbers.add(Integer.parseInt(s != null ? s : m.group(3)));
            int start = m.start();
            int end = m.end();
            int firstDot = htmlContent.substring(0, start).lastIndexOf(".");
            int lastDot = htmlContent.indexOf(".", end);
            String sentence = htmlContent.substring(firstDot+1, lastDot+1);

            newHtmlContent = htmlContent.toString().replace(sentence, openStrong + sentence + closeStrong);

        }
        //for (String el : figureRefs) {
            //newHtmlContent = htmlContent.toString().replace(el, openStrong + el + closeStrong);
        //}
        // now htmlContent has <strong> tags in sentences with figures

        System.out.println(numbers);

        return newHtmlContent;
    }

    public boolean isOrdered() {
        List<Integer> n = new ArrayList<>(numbers);
        numbers.sort(Comparator.<Integer>naturalOrder());
        return n.equals(numbers);
    }

    public void editHTML() {
        String newHtmlContent = setNumbersHTML();
        try(Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("outfilename.html"), "windows-1251"))) {
            out.write(newHtmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FigureSearcher figureSearcher = new FigureSearcher(HTML_PATH);
        System.out.println(figureSearcher.figureRefs);
        System.out.println(figureSearcher.isOrdered());
        figureSearcher.editHTML();
    }
}
