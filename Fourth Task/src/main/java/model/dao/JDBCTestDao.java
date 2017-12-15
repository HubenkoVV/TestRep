package model.dao;

import com.sun.nio.sctp.AbstractNotificationHandler;
import model.dao.interfaces.TestDao;
import model.entity.Question;
import model.entity.Test;
import model.mapper.AnswerMapper;
import model.mapper.QuestionMapper;
import model.mapper.TestMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.util.Arrays.asList;

public class JDBCTestDao implements TestDao {
    private String language;
    private Connection connection;
    private TestMapper testMapper = new TestMapper();

    public JDBCTestDao(Connection connection, String language) {
        this.connection = connection;
        this.language = language;
    }

    @Override
    public void create(Test test) {
        try(PreparedStatement ps = connection.prepareStatement(
                "insert into test (topic,language)" +
                        "values (?,?)")){
            ps.setString(1, test.getTopic());
            ps.setString(2, language);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Test findByID(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "select * from test where id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Test test = testMapper.extractFromResultSet(rs);
            ps.close();
            return  test;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Test> findAll() {
        QuestionMapper questionMapper = new QuestionMapper();
        AnswerMapper answerMapper = new AnswerMapper();

        List<Test> tests = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(
                "select * from test left join question using(idtest) left join answer using(idquestion) " +
                        "where test.language = ?")){
            ps.setString(1,language);
            ResultSet rs = ps.executeQuery();
            Set<Question> questions = new HashSet<>();
            Set<Test> testMap = new HashSet<>();
            while(rs.next()) {
                Test test = testMapper.makeUniqueTest(testMap, rs);
                if(rs.getInt("idquestion") != 0) {
                    Question question = questionMapper.makeUniqueQuestion(questions, rs);
                    if(rs.getInt("idanswer") != 0)
                        question.getAnswers().add(answerMapper.extractFromResultSet(rs));
                    test.getQuestions().add(question);
                }
            }
            testMap.forEach(test -> tests.add(test));
            ps.close();
            return tests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tests;
    }

    @Override
    public void update(Test test) {
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM test WHERE idtest = ?")){
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if(!connection.isClosed() && connection!=null)
            connection.close();
    }
}
