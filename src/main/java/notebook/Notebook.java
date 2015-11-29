package notebook;

import java.util.ArrayList;

/**
 * Created by Elizaveta Kapitonova on 29.11.15.
 */
public class Notebook {
    private ArrayList<NotebookEntry> entries = new ArrayList<>();
    String name;

    /**
     *
     *Class constructor specifying notebook name.
     */
    public Notebook(String notebookName){
        name = notebookName;
    }

    /**
     * Adds new entry.
     * @param newEntry
     * @return index of new entry in ArrayList entries
     */
    public NotebookEntry addEntry(NotebookEntry newEntry) {
        entries.add(newEntry);
        return newEntry;
    }

    /**
     * Removes first entry in notebook if such entry exists.
     * @param entry entry to delete
     * @return if element was removed
     */
    public boolean removeEntry(NotebookEntry entry) {
        boolean removed = entries.remove(entry);
        if (!removed) {
            System.out.println("No such entry.");
        }
        return removed;
    }

    /**
     * Removes entry by index.
     * @param index index of entry to delete.
     */
    public boolean removeEntry(int index) {
        try {
            entries.remove(index);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("No entry with such number: " + index);
            return false;
        }
    }

    /**
     * Replaces specified entry (oldEntry) with a new one
     * @param oldEntry
     * @param newEntry
     */
    public void editEntry(NotebookEntry oldEntry, NotebookEntry newEntry) {

        int index = entries.indexOf(oldEntry);
        if (index > -1) {
            entries.set(index, newEntry);
        }
        else {
            System.out.println("No such entry.");
        }
    }

    /**
     * Edits entry by index (if entry with such index exists)
     * @param index index of entry we want to edit
     * @param newEntry
     */
    public void editEntry(int index, NotebookEntry newEntry) {
        try {
            entries.set(index, newEntry);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("No entry with such number.");
        }
    }

    /**
     * Prints and gets  all text from entries in notebook.
     * @return all entries in notebook
     */
    public ArrayList<NotebookEntry> getEntries() {
        for (NotebookEntry entry : entries) {
            System.out.println(entry.entryText);
        }
        return entries;
    }
}
