package main.java.ua.training.model;

/**
 * Created by Влада on 13.11.2017.
 */
public class LoginAlreadyExists extends Exception {

    private String login;

    public LoginAlreadyExists(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }





}
