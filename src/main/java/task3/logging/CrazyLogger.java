package task3.logging;

/**
 * Created by Elizaveta Kapitonova on 15.12.15.
 */
public class CrazyLogger {
    StringBuilder loggerJournal = new StringBuilder();

    public void writeLog(String message) {
        loggerJournal.append(new MyLogData(message));
        loggerJournal.append('\n');
    }

    public String search(String s) {
        int i = loggerJournal.indexOf(s);
        if (i == -1) {
            return null;
        }
        else {
            if (i>loggerJournal.indexOf(";")) {
                int begin = loggerJournal.substring(0, i).lastIndexOf('\n') + 1;
                int end_rel = loggerJournal.substring(i).indexOf('\n');
                return loggerJournal.substring(begin, end_rel + i);
            }
            else {
                return loggerJournal.substring(0, loggerJournal.indexOf("\n"));
            }
        }
    }
    @Override
    public String toString() {
        return this.loggerJournal.toString();
    }

}
