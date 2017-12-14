package tests;

import model.dao.interfaces.TestDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.JDBCDaoFactory;

public class TestDaoTest {
    TestDao testDao;

    @Before
    public void before() throws Exception {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory("uk");
        testDao = jdbcDaoFactory.createTestDao();
    }

    @Test
    public void addAndDeleteTest() throws Exception {
        int index = testDao.findAll().size();
        testDao.create(new model.entity.Test.TestBuilder().buildTopic("N").build());
        int id = testDao.findAll().stream().filter(test -> test.getTopic().equals("N")).findFirst().get().getId();
        Assert.assertEquals(index+1, testDao.findAll().size());
        testDao.delete(id);
        Assert.assertEquals(index, testDao.findAll().size());
    }
}
