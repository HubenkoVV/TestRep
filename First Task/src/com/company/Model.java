package com.company;

/**
 * Class that includes business logic.
 * This class contains data
 * Created by Влада on 29.10.2017.
 */
public class Model {

    private String firstWord;
    private String secondWord;

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public String makeFullSentence() {
        return firstWord + " " + secondWord;
    }
}
