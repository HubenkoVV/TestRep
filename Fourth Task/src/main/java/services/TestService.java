package services;

import model.dao.JDBCTestDao;
import model.dao.interfaces.TestDao;
import model.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class TestService extends GeneralService<Test> {

    public TestService(TestDao jdbcTestDao) {
        this.jdbcDao = jdbcTestDao;
        makeList();
    }

    public void add(String topic){
        jdbcDao.create(new Test.TestBuilder().buildTopic(topic).build());
        makeList();
    }
}
