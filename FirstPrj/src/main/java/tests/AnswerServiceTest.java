package tests;


import model.dao.JDBCAnswerDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.AnswerService;
import services.JDBCDaoFactory;

public class AnswerServiceTest {
    AnswerService answerService;

    @Before
    public void before() throws Exception {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory("uk");
        answerService = new AnswerService(jdbcDaoFactory.createAnswerDao());
    }

    @Test
    public void addAndDeleteTest() throws Exception {
        int index = answerService.getListOfElements().size();
        answerService.add("N",1,true);
        int id = answerService.getListOfElements().stream().filter(answer -> answer.getText().equals("N")).findFirst().get().getId();
        Assert.assertEquals(index+1, answerService.getListOfElements().size());
        answerService.delete(id);
        Assert.assertEquals(index, answerService.getListOfElements().size());
    }

    @Test
    public void isRightAnswerTest() throws Exception {
        answerService.add("N",1,true);
        int id = answerService.getListOfElements().stream().filter(answer -> answer.getText().equals("N")).findFirst().get().getId();
        Assert.assertTrue(answerService.isRightAnswer(id));
        answerService.delete(id);
    }

    @Test
    public void isRightAnswer1Test() throws Exception {
        answerService.add("N",1,true);
        int id = answerService.getListOfElements().stream().filter(answer -> answer.getText().equals("N")).findFirst().get().getId();
        Assert.assertTrue(answerService.isRightAnswer(id, "N"));
        answerService.delete(id);
    }

}