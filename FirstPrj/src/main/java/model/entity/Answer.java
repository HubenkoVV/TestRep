package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private int id;
    private int idQuestion;
    private String text;
    private boolean right;

    void setId(int id) {
        this.id = id;
    }
    void setText(String text) {
        this.text = text;
    }
    void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }
    public void setRight(boolean right) {
        this.right = right;
    }

    public int getIdQuestion() {
        return idQuestion;
    }
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public boolean isRight() {
        return right;
    }

    @Override
    public String toString() {
        return id +
                ". '" + text + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (idQuestion != answer.idQuestion) return false;
        if (right != answer.right) return false;
        return text.equals(answer.text);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idQuestion;
        result = 31 * result + text.hashCode();
        result = 31 * result + (right ? 1 : 0);
        return result;
    }

    public static class AnswerBuilder{
        private int id;
        private int idQuestion;
        private String text;
        private boolean right;

        public AnswerBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public AnswerBuilder buildIdQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public AnswerBuilder buildText(String text) {
            this.text = text;
            return this;
        }

        public AnswerBuilder buildRight(boolean right) {
            this.right = right;
            return this;
        }

        public Answer build(){
            Answer answer = new Answer();
            answer.setId(id);
            answer.setRight(right);
            answer.setIdQuestion(idQuestion);
            answer.setText(text);
            return answer;
        }
    }
}
