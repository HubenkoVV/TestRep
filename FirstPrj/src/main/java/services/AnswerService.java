package services;

import model.dao.JDBCAnswerDao;
import model.dao.interfaces.AnswerDao;
import model.entity.Answer;
import java.util.List;

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
        return listOfElements.stream().filter(answer -> answer.getId() == id).findFirst().get().isRight();
    }

    public boolean isRightAnswer(int id, String text){
        return listOfElements.stream().filter(answer -> answer.getId() == id).findFirst().get().getText().equals(text);
    }
}

