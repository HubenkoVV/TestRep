package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String text;
    private int testId;
    private int complexity;
    private List<Answer> answers = new ArrayList<>();

    void setId(int id) {
        this.id = id;
    }
    void setText(String text) {
        this.text = text;
    }
    void setTest_id(int testId) {
        this.testId = testId;
    }
    void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public int getTestId() {
        return testId;
    }
    public List<Answer> getAnswers() { return answers;  }

    @Override
    public String toString() {
        return text + " complexity = " + complexity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (testId != question.testId) return false;
        if (complexity != question.complexity) return false;
        return text.equals(question.text);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + testId;
        result = 31 * result + complexity;
        return result;
    }

    public static class QuestionBuilder{
        private int id;
        private String text;
        private int testId;
        private int complexity;

        public QuestionBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public QuestionBuilder buildText(String text) {
            this.text = text;
            return this;
        }

        public QuestionBuilder buildTestId(int testId) {
            this.testId = testId;
            return this;
        }

        public QuestionBuilder buildComplexity(int complexity) {
            this.complexity = complexity;
            return this;
        }

        public Question build(){
            Question question = new Question();
            question.setId(id);
            question.setText(text);
            question.setTest_id(testId);
            question.setComplexity(complexity);
            return question;
        }
    }
}
