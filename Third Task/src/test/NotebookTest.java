package test;

import main.java.ua.training.model.Note;
import main.java.ua.training.model.Notebook;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Влада on 13.11.2017.
 */
public class NotebookTest {
    @org.junit.Test
    public void addingNote() throws Exception {
        int previous, current;
        Notebook notebook = new Notebook();

        previous = notebook.getNotebook().size();
        notebook.addingNote(new Note());
        current = notebook.getNotebook().size();
        Assert.assertTrue(previous +1 == current);
    }

}