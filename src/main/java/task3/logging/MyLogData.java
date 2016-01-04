package task3.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Elizaveta Kapitonova on 15.12.15.
 */
public class MyLogData {
    private LocalDateTime currDateTime;
    private String message;

    public final static String pattern = "dd-MM-dd : HH-mm";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    public MyLogData(String message) {
        this.currDateTime = LocalDateTime.now();
        this.message = message;
    }

    @Override
    public String toString() {
        return currDateTime.format(formatter) + "-" + message + ";";
    }


}
