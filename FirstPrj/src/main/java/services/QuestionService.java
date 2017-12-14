package services;

import model.dao.JDBCQuestionDao;
import model.dao.interfaces.QuestionDao;
import model.entity.Question;

public class QuestionService extends GeneralService<Question> {

    public QuestionService(QuestionDao jdbcQuestionDao) {
        this.jdbcDao = jdbcQuestionDao;
        makeList();
    }

    public void add(String text, int idTest, int complexity){
        jdbcDao.create(new Question.QuestionBuilder().buildText(text).buildTestId(idTest).buildComplexity(complexity).build());
        makeList();
    }
}
