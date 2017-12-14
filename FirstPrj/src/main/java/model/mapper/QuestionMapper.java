package model.mapper;

import model.entity.Question;
import model.entity.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class QuestionMapper implements GeneralMapper<Question> {
    public Question extractFromResultSet(ResultSet rs) throws SQLException {
        return new Question.QuestionBuilder()
                .buildId(rs.getInt("idquestion"))
                .buildTestId(rs.getInt("idtest"))
                .buildText(rs.getString("text_question"))
                .buildComplexity(rs.getInt("complexity"))
                .build();
    }

    public Question makeUniqueQuestion(Set<Question> questions, ResultSet rs) throws SQLException {
        Question question = extractFromResultSet(rs);
        questions.add(question);
        return questions.stream().filter(item -> item.getId() == question.getId()).findFirst().get();
    }
}
