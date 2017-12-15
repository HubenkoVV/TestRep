package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int id;
    private String topic;
    private List<Question> questions = new ArrayList<>();

    void setId(int id) { this.id = id;  }
    void setTopic(String topic) {  this.topic = topic;  }

    public int getId() {
        return id;
    }
    public String getTopic() {
        return topic;
    }
    public List<Question> getQuestions() {    return questions;   }

    public String toString() {
        return "Test{" +
                "id = " + id +
                ", topic = '" + topic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        return topic.equals(test.topic);
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }

    public static class TestBuilder{
        private int id;
        private String topic;

        public TestBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public TestBuilder buildTopic(String topic) {
            this.topic = topic;
            return this;
        }

        public Test build(){
            Test test = new Test();
            test.setId(id);
            test.setTopic(topic);
            return test;
        }
    }
}
