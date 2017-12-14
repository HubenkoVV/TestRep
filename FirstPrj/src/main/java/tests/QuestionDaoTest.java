package tests;

import model.dao.interfaces.QuestionDao;
import model.entity.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.JDBCDaoFactory;

public class QuestionDaoTest {
    QuestionDao questionDao;

    @Before
    public void before() throws Exception {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory("uk");
        questionDao = jdbcDaoFactory.createQuestionDao();
    }

    @Test
    public void addAndDeleteTest() throws Exception {
        int index = questionDao.findAll().size();
        questionDao.create(new Question.QuestionBuilder().buildTestId(1).buildText("N").build());
        int id = questionDao.findAll().stream().filter(question -> question.getText().equals("N")).findFirst().get().getId();
        Assert.assertEquals(index+1, questionDao.findAll().size());
        questionDao.delete(id);
        Assert.assertEquals(index, questionDao.findAll().size());
    }
}
