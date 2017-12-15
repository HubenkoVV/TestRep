package model.dao;

import model.dao.interfaces.AnswerDao;
import model.entity.Answer;
import model.entity.Question;
import model.mapper.AnswerMapper;
import model.mapper.QuestionMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCAnswerDao implements AnswerDao {
    private String language;
    private Connection connection;
    private AnswerMapper answerMapper = new AnswerMapper();

    public JDBCAnswerDao(Connection connection, String language) {
        this.connection = connection;
        this.language = language;
    }

    @Override
    public void create(Answer answer) {
        try(PreparedStatement ps = connection.prepareStatement(
                "insert into answer (text_answer, idquestion, right_answer, language)" +
                        "values (?,?,?,?)")){
            ps.setString(1, answer.getText());
            ps.setInt(2, answer.getIdQuestion());
            ps.setBoolean(3, answer.isRight());
            ps.setString(4, language);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Answer findByID(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "select * from answer where idanswer = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Answer answer = answerMapper.extractFromResultSet(rs);
            ps.close();
            return  answer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Answer> findAll() {
        QuestionMapper questionMapper = new QuestionMapper();

        List<Answer> answers = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(
                "select * from answer left join question using(idquestion) where answer.language = ?")){
            ps.setString(1, language);
            Set<Question> questions = new HashSet<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Answer answer = answerMapper.extractFromResultSet(rs);
                Question question = questionMapper.makeUniqueQuestion(questions,rs);
                question.getAnswers().add(answer);
                answers.add(answer);
            }
            ps.close();
            return answers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    @Override
    public void update(Answer answer) {

    }

    @Override
    public void delete(int id) {
        try(PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM answer WHERE idanswer = ?")){
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
