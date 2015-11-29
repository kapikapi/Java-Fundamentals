package notebook;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kapikapi on 29.11.15.
 */
public class NotebookTest {
    private Notebook notebook;
    private Notebook preNotebook;
    private final int TEST_SIZE = 10;
    private final List<String> testData = new ArrayList<>(TEST_SIZE);


    @Before
    public void prepareData() {
        notebook = new Notebook("First Notebook");
    }

    @Test
    public void testGetEntries() throws Exception {;
        for (int i=0; i<TEST_SIZE; i++) {
            testData.add("Entry number" +"" + i);
        }
        int j = 0;
        for (String el : testData) {
            NotebookEntry newEntry = notebook.addEntry(new NotebookEntry(el));
            assertTrue(notebook.getEntries().contains(newEntry));
            assertEquals(j, notebook.getEntries().size());
            j++;
        }
    }

    @Test
    public void testAddEntry() throws Exception {
        preNotebook = notebook;
        NotebookEntry en5 = new NotebookEntry("Fifth entry");
        notebook.addEntry(en5);
        assertTrue(notebook.getEntries().contains(en5));
        notebook.getEntries().remove(en5);
        assertEquals(preNotebook.getEntries(), notebook.getEntries());
    }

    @Test
    public void testRemoveEntry() throws Exception {
        preNotebook = notebook;
        NotebookEntry entryToRemove = new NotebookEntry("I will be removed");
        notebook.addEntry(entryToRemove);
        boolean removed = notebook.removeEntry(entryToRemove);
        assertTrue(removed);
        assertFalse(notebook.getEntries().contains(entryToRemove));
        assertEquals(preNotebook.getEntries(), notebook.getEntries());
    }

    @Test
    public void testRemoveEntryByIndex() throws Exception {

        NotebookEntry entryToRemove = new NotebookEntry("I will be removed by index");
        notebook.addEntry(entryToRemove);
        int sz = notebook.getEntries().size();
        int idToRemove = notebook.getEntries().indexOf(entryToRemove);
        boolean removed = notebook.removeEntry(idToRemove);
        assertTrue(removed);
        assertFalse(notebook.getEntries().contains(entryToRemove));
        assertEquals(sz - 1, notebook.getEntries().size());
    }

    @Test
    public void testEditEntry() throws Exception {
        NotebookEntry entryToEdit = new NotebookEntry("Before");
        NotebookEntry newEntry = new NotebookEntry("After");
        notebook.addEntry(entryToEdit);
        int i = notebook.getEntries().indexOf(entryToEdit);
        notebook.editEntry(entryToEdit, newEntry);
        assertTrue(notebook.getEntries().contains(newEntry));
        assertEquals("After", notebook.getEntries().get(i).entryText);
    }

    @Test
    public void testEditEntryByIndex() throws Exception {
        NotebookEntry entryToEdit = new NotebookEntry("Before editing by index");
        NotebookEntry newEntry = new NotebookEntry("After editing by index");
        notebook.addEntry(entryToEdit);
        int i = notebook.getEntries().indexOf(entryToEdit);
        notebook.editEntry(i, newEntry);
        assertEquals(true, notebook.getEntries().contains(newEntry));
        assertEquals("After editing by index", notebook.getEntries().get(i).entryText);
    }
}