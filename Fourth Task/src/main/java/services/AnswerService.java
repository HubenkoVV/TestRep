package services;

import model.dao.JDBCAnswerDao;
import model.dao.interfaces.AnswerDao;
import model.entity.Answer;
import java.util.List;
import java.util.NoSuchElementException;

public class AnswerService extends GeneralService<Answer>{

    public AnswerService(AnswerDao jdbcAnswerDao) {
        this.jdbcDao = jdbcAnswerDao;
        makeList();
    }

    public void add(String text, int question, boolean rigth) {
        jdbcDao.create(new Answer.AnswerBuilder().buildText(text).buildRight(rigth).buildIdQuestion(question).build());
        makeList();
    }

    public boolean isRightAnswer(int id){
        try {
            return listOfElements.stream().filter(answer -> answer.getId() == id).findFirst().get().isRight();
        } catch (NoSuchElementException nse){
            return false;
        }
    }

    public boolean isRightAnswer(int id, String text){
        try {
            return listOfElements.stream().filter(answer -> answer.getId() == id).findFirst().get().getText().equals(text);
        } catch (NoSuchElementException nse){
            return false;
        }
    }
}

