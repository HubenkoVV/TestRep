package main.java.ua.training.model;

/**
 * Created by Влада on 13.11.2017.
 */
public class Note {

    private String login;
    private Groups group;
    private String number;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;

    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Note{" +
                "login='" + login + '\'' +
                ", group=" + group +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
