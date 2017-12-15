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

    public boolean isRightAnswer(int idQuestion, int id){
        try {
            Answer answer = getById(id);
            return answer.getIdQuestion() == idQuestion && answer.isRight();
        } catch (NoSuchElementException nse){
            return false;
        }
    }

    public boolean isRightAnswer(int id, int idQuestion ,String text){
        try {
            Answer answer = getById(id);
            return answer.getIdQuestion() == idQuestion && answer.getText().equals(text);
        } catch (NoSuchElementException nse){
            return false;
        }
    }
}

