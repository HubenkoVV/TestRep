package main.java.ua.training.model;

import java.util.ArrayList;

/**
 * Created by Влада on 13.11.2017.
 */
public class Notebook {

    private ArrayList<Note> notebook;

    public ArrayList<Note> getNotebook() {
        return notebook;
    }

    public void setNotebook(ArrayList<Note> notebook) {
        this.notebook = notebook;
    }

    public Notebook(){
        notebook = new ArrayList<Note>();
    }

    public void addingNote(Note note){
        notebook.add(note);
    }

    public boolean isLoginAlreadyExists(String login){
        boolean result = false;
        for(Note n : notebook){
            if(n.getLogin().equals(login)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
