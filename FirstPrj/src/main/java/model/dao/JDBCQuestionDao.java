package model.dao;

import model.dao.interfaces.QuestionDao;
import model.entity.Answer;
import model.entity.Question;
import model.entity.Test;
import model.mapper.AnswerMapper;
import model.mapper.QuestionMapper;
import model.mapper.TestMapper;

import java.sql.*;
import java.util.*;

public class JDBCQuestionDao implements QuestionDao {
    private String language;
    private String FIND_ALL = "select * from question left join test using(idtest) left join answer using(idquestion) " +
            "where question.language = ?";
    private Connection connection;
    private QuestionMapper questionMapper = new QuestionMapper();

    public JDBCQuestionDao(Connection connection, String language) {
        this.connection = connection;
        this.language = language;
    }

    @Override
    public void create(Question question) {
        try(PreparedStatement ps = connection.prepareStatement(
                "insert into question (text_question, idtest, complexity, language)" +
                        "values (?,?,?,?)")){
            ps.setString(1, question.getText());
            ps.setInt(2, question.getTestId());
            ps.setInt(3, question.getComplexity());
            ps.setString(4, language);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Question findByID(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "select * from question where id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Question answer = questionMapper.extractFromResultSet(rs);
            ps.close();
            return  answer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Question> findAll(boolean sorted){
        if(sorted)
            FIND_ALL = "select * from question left join test using(idtest) left join answer using(idquestion) " +
                    "order by complexity where question.language = ?";
        else FIND_ALL = "select * from question left join test using(idtest) left join answer using(idquestion) " +
                    "where question.language = ?";
        return findAll();
    }

    @Override
    public List<Question> findAll() {
        TestMapper testMapper = new TestMapper();
        AnswerMapper answerMapper = new AnswerMapper();

        List<Question> questions = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ALL)){
            ps.setString(1, language);
            Set<Test> tests = new HashSet<>();
            Set<Question> questionSet = new HashSet<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Question question = questionMapper.makeUniqueQuestion(questionSet, rs);
                Test test = testMapper.makeUniqueTest(tests, rs);
                if(rs.getInt("idanswer") != 0)
                    question.getAnswers().add(answerMapper.extractFromResultSet(rs));
                test.getQuestions().add(question);
            }
            questionSet.forEach(question-> questions.add(question));
            ps.close();
            return questions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void delete(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM question WHERE idquestion = ?")){
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
