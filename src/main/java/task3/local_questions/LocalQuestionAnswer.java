package task3.local_questions;

import java.io.IOException;
import java.util.*;

/**
 * Created by Elizaveta Kapitonova on 02.01.16.
 */
public class LocalQuestionAnswer {
    private static String country;
    private static String language;
    private static Locale locale;
    private ResourceBundle questions;
    private ResourceBundle answers;
    private final static String EXIT_WORD = "exit";

    public LocalQuestionAnswer() {
        int languageNumber = LocalQuestionAnswer.getLanguageNumber();
        switch (languageNumber) {
            case 1:
                country = "US";
                language = "en";
                break;
            case 2:
                country = "RU";
                language = "ru";
                break;
            default:
                country = "US";
                language = "en";
                System.out.println("Wrong language selection. Default language is English." + "\n"+ LANGUAGE_SELECTION);
        }
        locale = new Locale(language, country);
        answers = ResourceBundle.getBundle("Answers", locale);
        questions = ResourceBundle.getBundle("Questions", locale);
    }

    public String getAnswer(int questionNumber) {
        return answers.getString(String.valueOf(questionNumber));
    }

    private static int getLanguageNumber() {
        int n;
        System.out.println("Choose language. Выберите язык. " + LANGUAGE_SELECTION);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        return n;
    }

    private String getQuestions() {
        StringBuilder q = new StringBuilder();
        Enumeration<String> keyEnumeration = questions.getKeys();
        while (keyEnumeration.hasMoreElements()) {
            q.append(questions.getString(keyEnumeration.nextElement()) + "\n");
            // new String(val.getBytes("ISO-8859-1"), "UTF-8");
        }
        ResourceBundle usersRB = ResourceBundle.getBundle("User", locale);
        return usersRB.getString("1") + "\n" + q.toString();
    }


    private static final String LANGUAGE_SELECTION = "1 - English, 2 - Русский";

    public static void main(String[] args) {

        LocalQuestionAnswer lqa = new LocalQuestionAnswer();

        System.out.println(lqa.getQuestions());

        String number = "";
        try (Scanner scanner = new Scanner(System.in)) {
            Formatter formatter = new Formatter();
            ResourceBundle requestQuestionNumber = ResourceBundle.getBundle("User", locale);
            formatter.format(requestQuestionNumber.getString("2"), EXIT_WORD);
            while (!number.equals(EXIT_WORD)) {

                System.out.println(formatter);

                number = scanner.next();

                if (lqa.questions.containsKey(number)) {
                    System.out.println(lqa.questions.getString(number));
                    System.out.println(lqa.getAnswer(Integer.parseInt(number)));
                } else {
                    if (!number.equals(EXIT_WORD)) {
                        ResourceBundle noQuestionUser = ResourceBundle.getBundle("User", locale);
                        System.out.println(noQuestionUser.getString("3"));
                    }
                }
            }
        }

    }

}
